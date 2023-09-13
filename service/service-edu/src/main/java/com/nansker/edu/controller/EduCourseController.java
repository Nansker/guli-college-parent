package com.nansker.edu.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nansker.commonutils.result.PageResultData;
import com.nansker.commonutils.result.ResultData;
import com.nansker.edu.domain.EduCourse;
import com.nansker.edu.domain.dto.CourseDto;
import com.nansker.edu.domain.vo.CourseInfoVo;
import com.nansker.edu.domain.vo.CoursePublishVo;
import com.nansker.edu.service.EduCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
        PageResultData courseList = courseService.getCourseList(courseDto);
        return ResultData.ok().data(courseList);
    }

    @GetMapping("/{id}")
    public ResultData getCourseById(@PathVariable String id) {
        return ResultData.ok().data(courseService.getById(id));
    }

    @GetMapping("/publish/{id}")
    public ResultData getCoursePublishInfoById(@PathVariable String id){
        CoursePublishVo coursePublishVo = courseService.getCoursePublishInfoById(id);
        log.info("测试"+coursePublishVo.toString());
        return ResultData.ok().data(coursePublishVo);
    }

    @PostMapping
    public ResultData saveCourse(@RequestBody CourseInfoVo courseInfoVo){
        String courseId = courseService.saveCourseInfo(courseInfoVo);
        return ResultData.ok().data(courseId);
    }

    @PutMapping
    public ResultData updateCourse(@RequestBody CourseInfoVo courseInfoVo){
        courseService.updateCourseInfo(courseInfoVo);
        return ResultData.ok();
    }

    @PutMapping("/status/{courseId}/{status}")
    public ResultData updateCourseStatus(@PathVariable String courseId,@PathVariable String status){
        courseService.updateCourseStatus(courseId,status);
        return ResultData.ok();
    }
    @DeleteMapping("/{id}")
    public ResultData deleteCourse(@PathVariable String id){
        boolean result = courseService.removeById(id);
        if (!result){
            return ResultData.error();
        }
        return ResultData.ok();
    }
}
