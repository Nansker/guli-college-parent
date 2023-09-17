package com.nansker.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nansker.edu.domain.EduTeacher;
import com.nansker.edu.domain.dto.TeacherDto;
import com.nansker.edu.mapper.EduTeacherMapper;
import com.nansker.edu.service.EduTeacherService;
import org.springframework.stereotype.Service;

/**
 * @author Nansker
 * @description 针对表【edu_teacher(讲师)】的数据库操作Service实现
 * @createDate 2023-08-07 05:36:54
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {
	@Override
	public Page getTeacherList(TeacherDto teacherDto) {
		LambdaQueryWrapper<EduTeacher> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.like(StringUtils.isNotEmpty(teacherDto.getId()), EduTeacher::getId, teacherDto.getId());
		queryWrapper.like(StringUtils.isNotEmpty(teacherDto.getName()), EduTeacher::getName, teacherDto.getName());
		queryWrapper.orderByAsc(EduTeacher::getSort);
		Page<EduTeacher> page = new Page<>(teacherDto.getPageNum(), teacherDto.getPageSize());
		Page<EduTeacher> result = page(page, queryWrapper);
		return result;
	}
}