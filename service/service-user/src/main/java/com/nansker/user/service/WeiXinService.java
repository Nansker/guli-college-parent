package com.nansker.user.service;

/**
 * @author: Nansker
 * @date: 2023/9/21 19:11
 * @description: TODO
 */
public interface WeiXinService {
	/**
	 * @return java.lang.String
	 * @author Nansker
	 * @date 2023/9/21 19:13
	 * @description 获取微信登录二维码
	 */
	String genQrConnect();

	/**
	 * @param code
	 * @param state
	 * @return java.lang.String
	 * @author Nansker
	 * @date 2023/9/21 19:13
	 * @description 扫码登录回调
	 */
	String callback(String code, String state);

}
