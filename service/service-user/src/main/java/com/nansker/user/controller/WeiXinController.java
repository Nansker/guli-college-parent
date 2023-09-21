package com.nansker.user.controller;

import com.nansker.user.service.WeiXinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Nansker
 * @date 2023/9/21 15:29
 * @description TODO
 */
@Slf4j
@Controller
@RequestMapping("/user/wx")
public class WeiXinController {
	@Autowired
	WeiXinService weiXinService;

	@GetMapping("/login")
	public String genQrConnect() {
		String result = weiXinService.genQrConnect();
		return result;
	}

	@GetMapping("/callback")
	public String callback(String code, String state) {
		String result = weiXinService.callback(code, state);
		return result;
	}

}
