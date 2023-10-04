package com.nansker.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nansker.entity.user.SysUser;
import com.nansker.user.service.SysUserService;
import com.nansker.user.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

/**
* @author Nansker
* @description 针对表【sys_user(系统用户表)】的数据库操作Service实现
* @createDate 2023-10-03 23:37:19
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

}




