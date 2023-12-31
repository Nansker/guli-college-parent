package com.nansker.edu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nansker.utils.result.ResultData;
import com.nansker.entity.dto.CourseDto;
import com.nansker.entity.vo.CourseInfoVo;
import com.nansker.entity.vo.CoursePublishVo;
import com.nansker.edu.service.EduCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nansker
 * @date 2023/9/7 13:39
 * @description TODO
 */
@Slf4j
@RestController
@RequestMapping("/edu/course")
public class EduCourseController{
    @Autowired
    EduCourseService courseService;
    @GetMapping("/list")
    public ResultData listCourse(CourseDto courseDto) {
        Page result = courseService.getCourseList(courseDto);
        return ResultData.ok().pageData(result);
    }

    @GetMapping("/{id}")
    public ResultData getCourseById(@PathVariable String id) {
        return ResultData.ok().data(courseService.getById(id));
    }

    @GetMapping("/publish/{id}")
    public ResultData getCoursePublishInfoById(@PathVariable String id){
        CoursePublishVo coursePublishVo = courseService.getCoursePublishInfoById(id);
        return ResultData.ok().data(coursePublishVo);
    }
    @CacheEvict(value = "front", allEntries=true)
    @PostMapping
    public ResultData saveCourse(@RequestBody CourseInfoVo courseInfoVo){
        String courseId = courseService.saveCourseInfo(courseInfoVo);
        return ResultData.ok().data(courseId);
    }
    @CacheEvict(value = "front", allEntries=true)
    @PutMapping
    public ResultData updateCourse(@RequestBody CourseInfoVo courseInfoVo){
        courseService.updateCourseInfo(courseInfoVo);
        return ResultData.ok();
    }
    @CacheEvict(value = "front", allEntries=true)
    @PutMapping("/status/{courseId}/{status}")
    public ResultData updateCourseStatus(@PathVariable String courseId,@PathVariable String status){
        courseService.updateCourseStatus(courseId,status);
        return ResultData.ok();
    }
    @CacheEvict(value = "front", allEntries=true)
    @DeleteMapping("/{id}")
    public ResultData deleteCourse(@PathVariable String id){
        courseService.removeById(id);
        return ResultData.ok();
    }
}
