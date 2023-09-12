package com.nansker.edu.controller;

import com.nansker.commonutils.result.ResultData;
import com.nansker.edu.domain.EduTeacher;
import com.nansker.edu.domain.dto.TeacherDto;
import com.nansker.edu.service.EduTeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nansker
 * @date 2023/8/7 5:39
 * @description TODO
 */
@RestController
@RequestMapping("/edu/teacher")
@Slf4j
public class EduTeacherController {
    @Autowired
    EduTeacherService teacherService;

    @GetMapping("/list")
    public ResultData listTeacher(TeacherDto teacherDto) {
        return ResultData.ok().data(teacherService.getTeacherList(teacherDto));
    }

    @GetMapping("/all")
    public ResultData allTeacher(){
        return ResultData.ok().data(teacherService.list());
    }

    @GetMapping("/{id}")
    public ResultData getTeacherById(@PathVariable String id) {
        return ResultData.ok().data(teacherService.getById(id));
    }

    @PostMapping
    public ResultData addTeacher(@RequestBody EduTeacher teacher){
        boolean result = teacherService.save(teacher);
        if (!result){
            return ResultData.error();
        }
        return ResultData.ok();
    }

    @PutMapping
    public ResultData updateTeacher(@RequestBody EduTeacher teacher){
        boolean result = teacherService.updateById(teacher);
        if (!result){
            return ResultData.error();
        }
        return ResultData.ok();
    }

    @DeleteMapping("/{id}")
    public ResultData deleteTeacher(@PathVariable String id){
        boolean result = teacherService.removeById(id);
        if (!result){
            return ResultData.error();
        }
        return ResultData.ok();
    }
}