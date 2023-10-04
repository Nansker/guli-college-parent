package com.nansker.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nansker.entity.user.SysMember;

/**
* @author Nansker
* @description 针对表【sys_member(会员表)】的数据库操作Mapper
* @createDate 2023-09-18 12:31:25
* @Entity com.nansker.user.domain.SysMember
*/
public interface SysMemberMapper extends BaseMapper<SysMember> {
	Integer selectRegisterCount(String day);
}




