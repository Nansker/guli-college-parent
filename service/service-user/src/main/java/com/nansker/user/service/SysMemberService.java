package com.nansker.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nansker.entity.user.SysMember;
import com.nansker.entity.vo.LoginVo;
import com.nansker.entity.vo.RegisterVo;

/**
 * @author Nansker
 * @description 针对表【sys_member(会员表)】的数据库操作Service
 * @createDate 2023-09-18 12:31:25
 */
public interface SysMemberService extends IService<SysMember> {
	/**
	 * @param login 用户登录信息实体
	 * @return java.lang.String
	 * @author Nansker
	 * @date 2023/9/18 12:49
	 * @description 普通用户登录, 返回token
	 */
	String login(LoginVo login);

	/**
	 * @param register 用户注册信息实体
	 * @return void
	 * @author Nansker
	 * @date 2023/9/18 20:41
	 * @description 普通用户注册
	 */
	void register(RegisterVo register);

	/**
	 * @author Nansker
	 * @date 2023/10/3 14:46
	 * @param day 注册日期
	 * @return java.lang.Integer
	 * @description 根据日期获取用户注册数量
	*/
	Integer countRegisterByDay(String day);
}
