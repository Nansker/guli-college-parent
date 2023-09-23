package com.nansker.edu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nansker.entity.edu.EduCourseDescription;
import com.nansker.edu.service.EduCourseDescriptionService;
import com.nansker.edu.mapper.EduCourseDescriptionMapper;
import org.springframework.stereotype.Service;

/**
* @author Nansker
* @description 针对表【edu_course_description(课程简介)】的数据库操作Service实现
* @createDate 2023-09-06 21:52:24
*/
@Service
public class EduCourseDescriptionServiceImpl extends ServiceImpl<EduCourseDescriptionMapper, EduCourseDescription>
    implements EduCourseDescriptionService{

}




