package com.nansker.edu.service;

import com.nansker.entity.edu.EduCourseChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nansker.entity.vo.CourseChapterVo;

import java.util.List;

/**
* @author Nansker
* @description 针对表【edu_course_chapter(课程)】的数据库操作Service
* @createDate 2023-09-06 21:52:24
*/
public interface EduCourseChapterService extends IService<EduCourseChapter> {
	/**
	 * @author Nansker
	 * @date 2023/9/18 0:49
	 * @param courseId
	 * @return java.util.List<com.nansker.entity.vo.CourseChapterVo>
	 * @description 根据课程id获取课程大纲信息
	*/
	List<CourseChapterVo> getChapterInfoByCourseId(String courseId);
}
