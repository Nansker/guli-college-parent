package com.nansker.user.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Nansker
 * @date 2023/9/21 15:27
 * @description 微信配置类
 */
@Component
public class WeiXinConfig implements InitializingBean {
	@Value("${wx.open.app-id}")
	private String appId;
	@Value("${wx.open.app-secret}")
	private String appSecret;
	@Value("${wx.open.redirect-url}")
	private String redirectUrl;
	public static String WX_OPEN_APP_ID;
	public static String WX_OPEN_APP_SECRET;
	public static String WX_OPEN_REDIRECT_URL;
	@Override
	public void afterPropertiesSet() throws Exception {
		WX_OPEN_APP_ID = appId;
		WX_OPEN_APP_SECRET = appSecret;
		WX_OPEN_REDIRECT_URL = redirectUrl;
	}
}
