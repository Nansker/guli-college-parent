package com.nansker.edu.controller.front;

import com.nansker.commonutils.result.PageResultData;
import com.nansker.commonutils.result.ResultData;
import com.nansker.edu.domain.EduCourse;
import com.nansker.edu.domain.EduCourseDescription;
import com.nansker.edu.domain.EduTeacher;
import com.nansker.edu.domain.dto.CourseDto;
import com.nansker.edu.domain.vo.CourseChapterVo;
import com.nansker.edu.service.EduCourseChapterService;
import com.nansker.edu.service.EduCourseDescriptionService;
import com.nansker.edu.service.EduCourseService;
import com.nansker.edu.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author Nansker
 * @date 2023/9/15 22:30
 * @description TODO
 */
@RestController
@RequestMapping("/edu/front/course")
public class FrontCourseController {
	@Autowired
	EduCourseService courseService;
	@Autowired
	EduCourseChapterService courseChapterService;
	@Autowired
	EduCourseDescriptionService courseDescriptionService;
	@Autowired
	EduTeacherService teacherService;

	/**
	 * @param courseDto
	 * @return com.nansker.commonutils.result.ResultData
	 * @author Nansker
	 * @date 2023/9/15 22:34
	 * @description TODO
	 */
	@GetMapping("/list")
	public ResultData listCourse(CourseDto courseDto) {
		PageResultData courseList = courseService.getCourseList(courseDto);
		return ResultData.ok().data(courseList);
	}

	/**
	 * @param id
	 * @return com.nansker.commonutils.result.ResultData
	 * @author Nansker
	 * @date 2023/9/16 12:02
	 * @description 根据id获取课程详情及章节信息
	 */
	@GetMapping("/chapter/{id}")
	public ResultData getCourseAndChapterById(@PathVariable String id) {
		//课程基本信息
		EduCourse course = courseService.getById(id);
		//课程章节信息
		List<CourseChapterVo> chapterList = courseChapterService.getChapterInfoByCourseId(id);
		//课程描述信息
		EduCourseDescription courseDescription = courseDescriptionService.getById(id);
		//课程讲师信息
		EduTeacher teacher = teacherService.getById(course.getTeacherId());

		HashMap<String, Object> result = new HashMap<>();
		result.put("course", course);
		result.put("teacher", teacher);
		result.put("courseDescription", courseDescription);
		result.put("chapterList", chapterList);
		return ResultData.ok().data(result);
	}

}
