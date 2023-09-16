package com.nansker.mail.service.impl;

import com.nansker.mail.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Nansker
 * @date 2023/9/17 1:07
 * @description TODO
 */
@Service
public class MailServiceImpl implements MailService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Value("${spring.mail.username}")
	private String from;
	@Value("${spring.mail.nickname}")
	private String nickname;
	@Resource
	private JavaMailSender mailSender;

	@Override
	public void sendSimpleMail(String to, String subject, String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);
		message.setFrom(nickname + '<' + from + '>');
		mailSender.send(message);
	}

}
