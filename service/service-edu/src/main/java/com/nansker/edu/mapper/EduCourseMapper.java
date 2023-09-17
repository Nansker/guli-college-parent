package com.nansker.edu.mapper;

import com.nansker.edu.domain.EduCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nansker.edu.domain.vo.CoursePublishVo;

/**
* @author Nansker
* @description 针对表【edu_course(课程)】的数据库操作Mapper
* @createDate 2023-09-17 02:07:10
* @Entity com.nansker.edu.domain.EduCourse
*/
public interface EduCourseMapper extends BaseMapper<EduCourse> {
	CoursePublishVo getCoursePublishVoById(String id);
}




