package com.nansker.edu.controller;

import com.nansker.commonutils.result.ResultData;
import com.nansker.edu.domain.EduTeacher;
import com.nansker.edu.domain.dto.EduTeacherDto;
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
    EduTeacherService eduTeacherService;

    @GetMapping("/list")
    public ResultData listTeacher(EduTeacherDto teacherDto) {
        return ResultData.ok().data(eduTeacherService.getTeacherList(teacherDto));
    }

    @GetMapping("/{id}")
    public ResultData getTeacherById(@PathVariable String id) {
        return ResultData.ok().data(eduTeacherService.getById(id));
    }

    @PostMapping
    public ResultData addTeacher(@RequestBody EduTeacher teacher){
        boolean result = eduTeacherService.save(teacher);
        if (!result){
            return ResultData.error();
        }
        return ResultData.ok();
    }

    @PutMapping
    public ResultData updateTeacher(@RequestBody EduTeacher teacher){
        boolean result = eduTeacherService.updateById(teacher);
        if (!result){
            return ResultData.error();
        }
        return ResultData.ok();
    }

    @DeleteMapping("/{id}")
    public ResultData deleteTeacher(@PathVariable String id){
        boolean result = eduTeacherService.removeById(id);
        if (!result){
            return ResultData.error();
        }
        return ResultData.ok();
    }
}