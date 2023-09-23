package com.nansker.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Nansker
 * @date 2023/9/18 20:23
 * @description TODO
 */
@Data
public class RegisterVo implements Serializable {

	/**
	 * 用户昵称
	 */
	private String nickname;

	/**
	 * 邮箱地址
	 */
	private String email;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 验证码
	 */
	private String code;

}
