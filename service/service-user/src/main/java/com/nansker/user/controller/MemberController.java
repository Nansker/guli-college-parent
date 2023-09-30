package com.nansker.user.controller;

import com.nansker.entity.user.SysMember;
import com.nansker.entity.vo.LoginVo;
import com.nansker.entity.vo.RegisterVo;
import com.nansker.user.service.SysMemberService;
import com.nansker.utils.result.ResultData;
import com.nansker.utils.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author Nansker
 * @date 2023/9/18 12:32
 * @description TODO
 */
@RestController
@RequestMapping("/user")
public class MemberController {
	@Autowired
	SysMemberService memberService;

	@PostMapping("/login")
	public ResultData login(@RequestBody LoginVo login) {
		String token = memberService.login(login);
		HashMap<String, String> tokenMap = new HashMap<>();
		tokenMap.put("token", token);
		return ResultData.ok().data(tokenMap);
	}

	@PostMapping("/register")
	public ResultData register(@RequestBody RegisterVo register) {
		memberService.register(register);
		return ResultData.ok();
	}

	@GetMapping("/info")
	public ResultData getUserInfoByToken(HttpServletRequest request) {
		String id = JwtUtils.getUserIdByToken(request);
		SysMember user = memberService.getById(id);
		return ResultData.ok().data(user);
	}

	@GetMapping("/{id}")
	public SysMember getUserInfoById(@PathVariable("id") String id) {
		SysMember member = memberService.getById(id);
		return member;
	}

}
