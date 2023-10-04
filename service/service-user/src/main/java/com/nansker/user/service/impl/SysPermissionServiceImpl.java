package com.nansker.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nansker.entity.user.SysPermission;
import com.nansker.user.service.SysPermissionService;
import com.nansker.user.mapper.SysPermissionMapper;
import org.springframework.stereotype.Service;

/**
* @author Nansker
* @description 针对表【sys_permission(权限)】的数据库操作Service实现
* @createDate 2023-10-03 23:36:34
*/
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission>
    implements SysPermissionService{

}




