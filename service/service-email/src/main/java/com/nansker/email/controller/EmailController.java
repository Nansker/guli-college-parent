package com.nansker.email.controller;

import com.nansker.email.service.EmailService;
import com.nansker.utils.result.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nansker
 * @date 2023/9/17 1:12
 * @description TODO
 */
@RestController
@RequestMapping("/email")
public class EmailController {
	@Autowired
	private EmailService emailService;

	@RequestMapping("/send/{email}")
	public ResultData sendSimpleMail(@PathVariable String email){
		emailService.sendSimpleMail(email);
		return ResultData.ok();
	}
}
