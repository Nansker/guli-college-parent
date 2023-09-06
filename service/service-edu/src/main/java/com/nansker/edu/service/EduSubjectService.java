package com.nansker.edu.service;

import com.nansker.edu.domain.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nansker.edu.domain.vo.SubjectNestedVo;

import java.util.List;

/**
* @author: Nansker
* @description: 针对表【edu_subject(课程科目)】的数据库操作Service
* @createDate: 2023-08-26 18:59:06
*/
public interface EduSubjectService extends IService<EduSubject> {
    List<SubjectNestedVo> nestedList();
}
