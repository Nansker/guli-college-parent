package com.nansker.mail.service;

/**
 * @author Nansker
 * @date 2023/9/17 1:06
 * @description 邮件服务
 */
public interface MailService {
	/**
	 * @author Nansker
	 * @date 2023/9/17 1:09
	 * @param to 接收者邮件
	 * @param subject 邮件主题
	 * @param content 邮件内容
	 * @return void
	 * @description 简单文本邮件
	*/
	void sendSimpleMail(String to, String subject, String content);
}
