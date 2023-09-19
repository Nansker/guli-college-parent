package com.nansker.email.service;

/**
 * @author Nansker
 * @date 2023/9/17 1:06
 * @description 邮件服务
 */
public interface EmailService {
	/**
	 * @author Nansker
	 * @date 2023/9/17 1:09
	 * @return void
	 * @description 简单文本邮件
	*/
	void sendSimpleMail(String email);
}
