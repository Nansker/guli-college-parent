package com.nansker.edu.controller.front;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nansker.utils.result.ResultData;
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
import java.util.Map;

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

	@GetMapping("/list")
	public ResultData listCourse(CourseDto courseDto) {
		Page result = courseService.getCourseList(courseDto);
		return ResultData.ok().pageData(result);
	}

	@GetMapping("/chapter/{id}")
	public ResultData getCourseAndChapterById(@PathVariable String id) {
		Map result = courseService.getCourseAndChapterById(id);
		return ResultData.ok().data(result);
	}
}
