package com.nansker.edu.controller;

import com.nansker.commonutils.result.ResultData;
import com.nansker.edu.domain.EduSubject;
import com.nansker.edu.domain.vo.SubjectNestedVo;
import com.nansker.edu.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Nansker
 * @date 2023/8/26 23:16
 * @description TODO
 */
@RestController
@RequestMapping("/edu/subject")
public class EduSubjectController {
    @Autowired
    EduSubjectService eduSubjectService;

    @GetMapping("/list")
    public ResultData listSubject() {
        List<SubjectNestedVo> nestedVos = eduSubjectService.nestedList();
        return ResultData.ok().data(nestedVos);
    }
    @GetMapping("/{id}")
    public ResultData getSubjectById(@PathVariable String id) {
        return ResultData.ok().data(eduSubjectService.getById(id));
    }

    @PostMapping
    public ResultData addSubject(@RequestBody EduSubject subject){
        boolean result = eduSubjectService.save(subject);
        if (!result){
            return ResultData.error();
        }
        return ResultData.ok();
    }

    @PutMapping
    public ResultData updateTeacher(@RequestBody EduSubject subject){
        boolean result = eduSubjectService.updateById(subject);
        if (!result){
            return ResultData.error();
        }
        return ResultData.ok();
    }

    @DeleteMapping("/{id}")
    public ResultData deleteTeacher(@PathVariable String id){
        boolean result = eduSubjectService.removeById(id);
        if (!result){
            return ResultData.error();
        }
        return ResultData.ok();
    }
}
