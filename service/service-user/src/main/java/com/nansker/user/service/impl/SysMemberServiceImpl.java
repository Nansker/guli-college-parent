package com.nansker.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nansker.base.exception.CustomException;
import com.nansker.user.domain.SysMember;
import com.nansker.user.domain.vo.LoginVo;
import com.nansker.user.domain.vo.RegisterVo;
import com.nansker.user.mapper.SysMemberMapper;
import com.nansker.user.service.SysMemberService;
import com.nansker.utils.security.JwtUtils;
import com.nansker.utils.security.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author Nansker
 * @description 针对表【sys_member(会员表)】的数据库操作Service实现
 * @createDate 2023-09-18 12:31:25
 */
@Service
public class SysMemberServiceImpl extends ServiceImpl<SysMemberMapper, SysMember> implements SysMemberService {
	@Autowired
	RedisTemplate<String, String> redisTemplate;

	@Override
	public String login(LoginVo login) {
		String email = login.getEmail();
		String password = login.getPassword();

		//TODO 用户登录信息非空判断,检测异常
		if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
			throw new CustomException("登录信息为空");
		}

		//获取登录用户信息
		SysMember member = getOne(new LambdaQueryWrapper<SysMember>().eq(SysMember::getEmail, email));
		//TODO 用户未注册
		if (member == null) {
			throw new CustomException("用户未注册");
		}

		//校验密码
		if (!PasswordUtils.verifyPassword(password, member.getSalt(), member.getPassword())) {
			throw new CustomException("密码错误");
		}

		//校验用户状态
		if (member.getDisabled() == 1) {
			//已禁用
			throw new CustomException("用户已被禁用");
		}

		//使用JWT生成token
		String token = JwtUtils.getJwtToken(member.getId(), member.getNickname());
		return token;
	}

	@Override
	public void register(RegisterVo register) {
		//TODO 参数非空判断

		//校验验证码
		String redisCode = redisTemplate.opsForValue().get(register.getEmail());
		if (!register.getCode().equals(redisCode)) {
			throw new CustomException("验证码错误");
		}
		//校验邮箱是否重复
		Long count = baseMapper.selectCount(new LambdaQueryWrapper<SysMember>().eq(SysMember::getEmail, register.getEmail()));
		if (count > 0) {
			throw new CustomException("邮箱已被注册");
		}
		//保存注册信息
		SysMember member = new SysMember();
		member.setEmail(register.getEmail());
		member.setNickname(register.getNickname());
		//生成MD5盐加密密码
		String salt = PasswordUtils.generateSalt();
		String hashPassword = PasswordUtils.hashPassword(register.getPassword(), salt);
		member.setPassword(hashPassword);
		member.setSalt(salt);
		save(member);
	}

}