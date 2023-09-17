package com.nansker.edu.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nansker.utils.result.ResultData;
import com.nansker.edu.domain.EduCourse;
import com.nansker.edu.domain.EduTeacher;
import com.nansker.edu.domain.dto.TeacherDto;
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
@RequestMapping("/edu/front/teacher")
public class FrontTeacherController {
	@Autowired
	EduTeacherService teacherService;
	@Autowired
	EduCourseService courseService;

	@GetMapping("/list")
	public ResultData listTeacher(TeacherDto teacherDto) {
		Page result = teacherService.getTeacherList(teacherDto);
		return ResultData.ok().pageData(result);
	}

	@GetMapping("/all/{id}")
	public ResultData getTeacherAndCourseById(@PathVariable String id) {
		EduTeacher teacher = teacherService.getById(id);
		LambdaQueryWrapper<EduCourse> courseQueryWrapper = new LambdaQueryWrapper<>();
		courseQueryWrapper.eq(EduCourse::getTeacherId, id);
		List<EduCourse> courseList = courseService.list(courseQueryWrapper);
		HashMap<String, Object> result = new HashMap<>();
		result.put("teacher", teacher);
		result.put("courseList", courseList);
		return ResultData.ok().data(result);
	}

}
