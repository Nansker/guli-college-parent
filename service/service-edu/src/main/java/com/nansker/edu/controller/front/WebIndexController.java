package com.nansker.edu.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nansker.commonutils.result.ResultData;
import com.nansker.edu.domain.EduCourse;
import com.nansker.edu.domain.EduTeacher;
import com.nansker.edu.service.EduCourseService;
import com.nansker.edu.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author Nansker
 * @date 2023/9/15 22:01
 * @description TODO
 */
@RestController
@RequestMapping("/edu/front")
public class WebIndexController {
	@Autowired
	EduCourseService courseService;
	@Autowired
	EduTeacherService teacherService;

	/**
	 * @return com.nansker.commonutils.result.ResultData
	 * @author Nansker
	 * @date 2023/9/15 22:08
	 * @description 获取用户端首页课程列表、讲师列表数据
	 */
	@GetMapping("/index")
	public ResultData getWebIndexData() {
		LambdaQueryWrapper<EduCourse> courseUpdateWrapper = new LambdaQueryWrapper<>();
		courseUpdateWrapper.orderByDesc(EduCourse::getViewCount);
		courseUpdateWrapper.last("limit 8");
		List<EduCourse> courseList = courseService.list(courseUpdateWrapper);

		LambdaQueryWrapper<EduTeacher> teacherQueryWrapper = new LambdaQueryWrapper<>();
		teacherQueryWrapper.orderByDesc(EduTeacher::getLevel);
		teacherQueryWrapper.last("limit 4");
		List<EduTeacher> teacherList = teacherService.list(teacherQueryWrapper);

		HashMap<String, Object> result = new HashMap<>();
		result.put("courseList",courseList);
		result.put("teacherList",teacherList);
		return ResultData.ok().data(result);
	}

}
