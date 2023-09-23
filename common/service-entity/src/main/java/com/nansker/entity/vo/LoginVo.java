package com.nansker.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Nansker
 * @date 2023/9/18 20:22
 * @description TODO
 */
@Data
public class LoginVo implements Serializable {
	/**
	 * 邮箱地址
	 */
	private String email;

	/**
	 * 密码
	 */
	private String password;

}
