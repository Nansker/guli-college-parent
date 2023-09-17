package com.nansker.edu.controller;

import com.nansker.utils.result.ResultData;
import com.nansker.edu.domain.EduCourseVideo;
import com.nansker.edu.service.EduCourseVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nansker
 * @date 2023/9/6 21:54
 * @description TODO
 */
@RestController
@RequestMapping("/edu/course/video")
public class EduCourseVideoController {
	@Autowired
	EduCourseVideoService courseVideoService;

	@GetMapping("/{id}")
	public ResultData getChapterById(@PathVariable String id){
		EduCourseVideo courseVideo = courseVideoService.getById(id);
		return ResultData.ok().data(courseVideo);
	}

	@PostMapping
	public ResultData addCourseChapterVideo(@RequestBody EduCourseVideo courseVideo){
		boolean result = courseVideoService.save(courseVideo);
		if (!result){
			return ResultData.error();
		}
		return ResultData.ok();
	}
	@DeleteMapping("/{id}")
	public ResultData deleteChapter(@PathVariable String id){
		boolean result = courseVideoService.removeById(id);
		if (!result){
			return ResultData.error();
		}
		return ResultData.ok();
	}

	@PutMapping
	public ResultData updateChapter(@RequestBody EduCourseVideo courseVideo){
		boolean result = courseVideoService.updateById(courseVideo);
		if (!result){
			return ResultData.error();
		}
		return ResultData.ok();
	}
}
