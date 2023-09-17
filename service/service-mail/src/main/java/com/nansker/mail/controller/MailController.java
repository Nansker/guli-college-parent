package com.nansker.mail.controller;

import com.nansker.mail.service.MailService;
import com.nansker.utils.result.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nansker
 * @date 2023/9/17 1:12
 * @description TODO
 */
@RestController
@RequestMapping("/mail")
public class MailController {
	@Autowired
	private MailService mailService;

	@RequestMapping("/test")
	public ResultData sendSimpleMail(){
		mailService.sendSimpleMail("2771557108@qq.com","测试标题","测试文本内容");
		return ResultData.ok();
	}
}
