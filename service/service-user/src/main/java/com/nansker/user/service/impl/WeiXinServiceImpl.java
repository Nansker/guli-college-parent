package com.nansker.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.Gson;
import com.nansker.base.exception.CustomException;
import com.nansker.user.config.WeiXinConfig;
import com.nansker.user.domain.SysMember;
import com.nansker.user.service.SysMemberService;
import com.nansker.user.service.WeiXinService;
import com.nansker.utils.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * @author Nansker
 * @date 2023/9/21 19:12
 * @description TODO
 */
@Service
public class WeiXinServiceImpl implements WeiXinService {
	@Autowired
	SysMemberService memberService;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	Gson gson;

	@Override
	public String genQrConnect() {
		// 微信开放平台授权baseUrl
		String baseUrl = "https://open.weixin.qq.com/connect/qrconnect" + "?appid=%s" + "&redirect_uri=%s" + "&response_type=code" + "&scope=snsapi_login" + "&state=%s" + "#wechat_redirect";
		// 回调地址
		String redirectUrl = WeiXinConfig.WX_OPEN_REDIRECT_URL; //获取业务服务器重定向地址
		try {
			redirectUrl = URLEncoder.encode(redirectUrl, "UTF-8"); //url编码
		} catch (UnsupportedEncodingException e) {
			throw new CustomException(e.getMessage());
		}
		String state = "nansker";
		//生成qrcodeUrl
		String qrcodeUrl = String.format(baseUrl, WeiXinConfig.WX_OPEN_APP_ID, redirectUrl, state);
		return "redirect:" + qrcodeUrl;
	}

	@Override
	public String callback(String code, String state) {
		//根据code请求微信Api，获取access_token和openid
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";
		String accessUrl = String.format(url, WeiXinConfig.WX_OPEN_APP_ID, WeiXinConfig.WX_OPEN_APP_SECRET, code);
		ResponseEntity<String> response = restTemplate.getForEntity(accessUrl, String.class);
		Map responseMap = gson.fromJson(response.getBody(), Map.class);
		String accessToken = (String) responseMap.get("access_token");
		String openid = (String) responseMap.get("openid");
		//查询用户是否使用过微信登录
		SysMember member = memberService.getOne(new QueryWrapper<SysMember>().eq("openid", openid));
		if (member == null) {
			//新用户登录,访问腾讯服务器获取微信用户信息
			String baseUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo" + "?access_token=%s" + "&openid=%s";
			String userInfoUrl = String.format(baseUserInfoUrl, accessToken, openid);
			ResponseEntity<String> responseUserInfo = restTemplate.getForEntity(userInfoUrl, String.class);
			//解析数据
			Map userInfoMap = gson.fromJson(responseUserInfo.getBody(), Map.class);
			SysMember newMember = new SysMember();
			newMember.setOpenid((String) userInfoMap.get("openid"));
			newMember.setNickname((String) userInfoMap.get("nickname"));
			newMember.setAvatar((String) userInfoMap.get("headimgurl"));
			//保存用户数据
			memberService.save(newMember);
		}
		// 生成jwt
		String token = JwtUtils.getJwtToken(member.getId(), member.getNickname());
		return "redirect:http://localhost:3000?token=" + token;
	}

}
