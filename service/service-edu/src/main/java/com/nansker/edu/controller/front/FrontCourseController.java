package com.nansker.edu.controller.front;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nansker.edu.service.EduCourseChapterService;
import com.nansker.edu.service.EduCourseDescriptionService;
import com.nansker.edu.service.EduCourseService;
import com.nansker.edu.service.EduTeacherService;
import com.nansker.entity.dto.CourseDto;
import com.nansker.entity.vo.CourseDetailsVo;
import com.nansker.utils.result.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

	@GetMapping("/details/{id}")
	public ResultData getCourseDetailsById(HttpServletRequest request, @PathVariable String id) {
		CourseDetailsVo detailsVo = courseService.getCourseDetailsById(request, id);
		return ResultData.ok().data(detailsVo);
	}

	@GetMapping("/details/vo/{id}")
	public CourseDetailsVo getCourseDetails(HttpServletRequest request, @PathVariable("id") String id) {
		CourseDetailsVo detailsVo = courseService.getCourseDetailsById(request, id);
		return detailsVo;
	}

}
