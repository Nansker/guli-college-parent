package com.nansker.edu.mapper;

import com.nansker.entity.edu.EduCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nansker.entity.vo.CoursePublishVo;

/**
* @author Nansker
* @description 针对表【edu_course(课程)】的数据库操作Mapper
* @createDate 2023-09-17 02:07:10
* @Entity com.nansker.entity.edu.EduCourse
*/
public interface EduCourseMapper extends BaseMapper<EduCourse> {
	CoursePublishVo getCoursePublishVoById(String id);
}




