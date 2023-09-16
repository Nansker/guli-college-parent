package com.nansker.edu.mapper;

import com.nansker.edu.domain.EduCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nansker.edu.domain.vo.CoursePublishVo;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Nansker
* @description 针对表【edu_course(课程)】的数据库操作Mapper
* @createDate 2023-09-07 13:45:06
* @Entity com.nansker.edu.domain.EduCourse
*/
public interface EduCourseMapper extends BaseMapper<EduCourse> {
	CoursePublishVo getCoursePublishVoById(String id);
}




