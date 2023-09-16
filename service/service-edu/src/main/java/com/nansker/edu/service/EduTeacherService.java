package com.nansker.edu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nansker.utils.result.PageResultData;
import com.nansker.edu.domain.EduTeacher;
import com.nansker.edu.domain.dto.TeacherDto;

/**
* @author Nansker
* @description 针对表【edu_teacher(讲师)】的数据库操作Service
* @createDate 2023-08-07 05:36:54
*/
public interface EduTeacherService extends IService<EduTeacher> {
    PageResultData getTeacherList(TeacherDto teacher);
}
