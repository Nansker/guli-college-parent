package com.nansker.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nansker.edu.domain.EduSubject;
import com.nansker.edu.domain.vo.SubjectNestedVo;
import com.nansker.edu.domain.vo.SubjectVo;
import com.nansker.edu.mapper.EduSubjectMapper;
import com.nansker.edu.service.EduSubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nansker
 * @description 针对表【edu_subject(课程科目)】的数据库操作Service实现
 * @createDate 2023-08-26 18:59:06
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public List<SubjectNestedVo> nestedList() {
        ArrayList<SubjectNestedVo> subjectNestedVos = new ArrayList<>();
        //获取一级分据类数
        LambdaQueryWrapper<EduSubject> firstSubjectQueryWrapper = new LambdaQueryWrapper<>();
        firstSubjectQueryWrapper.eq(EduSubject::getParentId, 0);
        firstSubjectQueryWrapper.orderByAsc(EduSubject::getSort, EduSubject::getId);
        List<EduSubject> subjects = list(firstSubjectQueryWrapper);
        //获取二级分类数据
        LambdaQueryWrapper<EduSubject> secondSubjectQueryWrapper = new LambdaQueryWrapper<>();
        secondSubjectQueryWrapper.ne(EduSubject::getParentId, 0);
        secondSubjectQueryWrapper.orderByAsc(EduSubject::getSort, EduSubject::getId);
        List<EduSubject> subSubjects = list(secondSubjectQueryWrapper);

        subjects.stream().forEach((subject) -> {
            //创建一级vo对象
            SubjectNestedVo subjectNestedVo = new SubjectNestedVo();
            BeanUtils.copyProperties(subject, subjectNestedVo);
            subjectNestedVos.add(subjectNestedVo);
            //填充二级vo对象
            ArrayList<SubjectVo> subSubjectVos = new ArrayList<>();
            subSubjects.stream().forEach((subSubject) -> {
                if (subject.getId().equals(subSubject.getParentId())) {
                    //创建二级vo对象
                    SubjectVo subSubjectVo = new SubjectVo();
                    BeanUtils.copyProperties(subSubject, subSubjectVo);
                    subSubjectVos.add(subSubjectVo);
                }
            });
            subjectNestedVo.setChildren(subSubjectVos);
        });
        return subjectNestedVos;
    }

}




