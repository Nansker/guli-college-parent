package com.nansker.edu.service;

import com.nansker.edu.domain.EduCourseChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nansker.edu.domain.vo.CourseChapterVo;

import java.util.List;

/**
* @author Nansker
* @description 针对表【edu_course_chapter(课程)】的数据库操作Service
* @createDate 2023-09-06 21:52:24
*/
public interface EduCourseChapterService extends IService<EduCourseChapter> {
	List<CourseChapterVo> getChapterInfoByCourseId(String courseId);
}
