package com.nansker.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nansker.edu.domain.EduTeacher;
import com.nansker.edu.domain.dto.TeacherDto;

/**
* @author Nansker
* @description 针对表【edu_teacher(讲师)】的数据库操作Service
* @createDate 2023-08-07 05:36:54
*/
public interface EduTeacherService extends IService<EduTeacher> {
    /**
     * @author Nansker
     * @date 2023/9/18 0:48
     * @param teacher
     * @return com.baomidou.mybatisplus.extension.plugins.pagination.Page
     * @description 分页查询讲师列表
    */
    Page getTeacherList(TeacherDto teacher);
}
