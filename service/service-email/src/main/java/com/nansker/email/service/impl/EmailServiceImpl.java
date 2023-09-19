package com.nansker.email.service.impl;

import com.nansker.email.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author Nansker
 * @date 2023/9/17 1:07
 * @description TODO
 */
@Service
public class EmailServiceImpl implements EmailService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Value("${spring.mail.username}")
	private String from;
	@Value("${spring.mail.nickname}")
	private String nickname;
	@Resource
	private JavaMailSender mailSender;
	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	@Override
	public void sendSimpleMail(String email) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		//生成六位随机验证码
		int code = (int) ((Math.random() * 9 + 1) * 100000);
		//验证码保存到redis,设置有效期
		redisTemplate.opsForValue().set(email, String.valueOf(code), 10, TimeUnit.MINUTES);
		String content = "尊敬的谷粒学院用户：\n      我们收到了您的注册邮箱验证，您的验证码是：" + code + "。\n        验证码十分钟内有效,请妥善保管您的验证码,如果不是你本人操作请忽略以上内容。";
		simpleMailMessage.setTo(email);
		simpleMailMessage.setSubject("【谷粒学院】用户邮箱认证");
		simpleMailMessage.setText(content);
		simpleMailMessage.setFrom(nickname + '<' + from + '>');
		mailSender.send(simpleMailMessage);
	}

}
