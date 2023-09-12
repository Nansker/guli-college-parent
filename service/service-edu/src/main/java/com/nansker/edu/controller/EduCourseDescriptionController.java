package com.nansker.edu.controller;

import com.nansker.commonutils.result.ResultData;
import com.nansker.edu.domain.EduCourseDescription;
import com.nansker.edu.service.EduCourseDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nansker
 * @date 2023/9/6 21:53
 * @description TODO
 */
@RestController
@RequestMapping("/edu/course/desc")
public class EduCourseDescriptionController {
	@Autowired
	EduCourseDescriptionService courseDescriptionService;
	@GetMapping("/{id}")
	public ResultData getDescriptionById(@PathVariable String id){
		EduCourseDescription description = courseDescriptionService.getById(id);
		return ResultData.ok().data(description);
	}
}
