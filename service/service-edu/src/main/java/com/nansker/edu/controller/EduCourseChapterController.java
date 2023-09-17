package com.nansker.edu.controller;

import com.nansker.utils.result.ResultData;
import com.nansker.edu.domain.EduCourseChapter;
import com.nansker.edu.domain.vo.CourseChapterVo;
import com.nansker.edu.service.EduCourseChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Nansker
 * @date 2023/9/6 21:53
 * @description TODO
 */
@RestController
@RequestMapping("/edu/course/chapter")
public class EduCourseChapterController {
	@Autowired
	EduCourseChapterService courseChapterService;

	@GetMapping("/{id}")
	public ResultData getChapterById(@PathVariable String id){
		EduCourseChapter chapter = courseChapterService.getById(id);
		return ResultData.ok().data(chapter);
	}

	@GetMapping("/list/{courseId}")
	public ResultData getCourseChapterListByCourseId(@PathVariable String courseId) {
		List<CourseChapterVo> chapterVos = courseChapterService.getChapterInfoByCourseId(courseId);
		return ResultData.ok().data(chapterVos);
	}

	@PostMapping
	public ResultData addCourseChapter(@RequestBody EduCourseChapter courseChapter){
		boolean result = courseChapterService.save(courseChapter);
		if (!result){
			return ResultData.error();
		}
		return ResultData.ok();
	}

	@DeleteMapping("/{id}")
	public ResultData deleteChapter(@PathVariable String id){
		boolean result = courseChapterService.removeById(id);
		if (!result){
			return ResultData.error();
		}
		return ResultData.ok();
	}
	
	@PutMapping
	public ResultData updateChapter(@RequestBody EduCourseChapter courseChapter){
		boolean result = courseChapterService.updateById(courseChapter);
		if (!result){
			return ResultData.error();
		}
		return ResultData.ok();
	}
}
