package com.nansker.user.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员表
 *
 * @TableName sys_member
 */
@TableName(value = "sys_member")
@Data
public class SysMember implements Serializable {
	/**
	 * 会员id
	 */
	@TableId(type = IdType.ASSIGN_ID)
	private String id;

	/**
	 * 微信openid
	 */
	private String openid;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 加密盐
	 */
	private String salt;

	/**
	 * 昵称
	 */
	private String nickname;

	/**
	 * 性别 1 女，2 男
	 */
	private Integer sex;

	/**
	 * 年龄
	 */
	private Integer age;

	/**
	 * 用户头像
	 */
	private String avatar;

	/**
	 * 用户签名
	 */
	private String sign;

	/**
	 * 是否禁用 1（true）已禁用，  0（false）未禁用
	 */
	private Integer disabled;

	/**
	 * 逻辑删除 1（true）已删除， 0（false）未删除
	 */
	private Integer isDeleted;

	/**
	 * 创建时间
	 */
	@TableField(fill = FieldFill.INSERT)
	private Date gmtCreate;

	/**
	 * 更新时间
	 */
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date gmtModified;

	@TableField(exist = false)
	private static final long serialVersionUID = 1L;

}