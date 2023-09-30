package com.nansker.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nansker.edu.client.OrderClient;
import com.nansker.edu.mapper.EduCourseMapper;
import com.nansker.edu.service.EduCourseChapterService;
import com.nansker.edu.service.EduCourseDescriptionService;
import com.nansker.edu.service.EduCourseService;
import com.nansker.edu.service.EduTeacherService;
import com.nansker.entity.dto.CourseDto;
import com.nansker.entity.edu.EduCourse;
import com.nansker.entity.edu.EduCourseDescription;
import com.nansker.entity.edu.EduTeacher;
import com.nansker.entity.vo.CourseChapterVo;
import com.nansker.entity.vo.CourseDetailsVo;
import com.nansker.entity.vo.CourseInfoVo;
import com.nansker.entity.vo.CoursePublishVo;
import com.nansker.utils.security.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Nansker
 * @description 针对表【edu_course(课程)】的数据库操作Service实现
 * @createDate 2023-09-17 02:07:10
 */
@Slf4j
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {
	@Autowired
	EduTeacherService teacherService;
	@Autowired
	EduCourseDescriptionService courseDescriptionService;
	@Autowired
	EduCourseChapterService courseChapterService;
	@Autowired
	OrderClient orderClient;

	@Override
	public Page getCourseList(CourseDto courseDto) {
		LambdaQueryWrapper<EduCourse> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.like(StringUtils.isNotEmpty(courseDto.getId()), EduCourse::getId, courseDto.getId());
		queryWrapper.like(StringUtils.isNotEmpty(courseDto.getTitle()), EduCourse::getTitle, courseDto.getTitle());
		queryWrapper.eq(StringUtils.isNotEmpty(courseDto.getStatus()), EduCourse::getStatus, courseDto.getStatus());
		queryWrapper.orderByDesc(EduCourse::getGmtCreate);
		Page<EduCourse> page = new Page<>(courseDto.getPageNum(), courseDto.getPageSize());
		return page(page, queryWrapper);
	}

	@Override
	public CoursePublishVo getCoursePublishInfoById(String id) {
		return baseMapper.getCoursePublishVoById(id);
	}

	@Override
	public CourseDetailsVo getCourseDetailsById(HttpServletRequest request, String id) {
		//课程基本信息
		EduCourse course = getById(id);
		//课程讲师信息
		EduTeacher teacher = teacherService.getById(course.getTeacherId());
		//课程描述信息
		EduCourseDescription courseDescription = courseDescriptionService.getById(id);
		//课程章节信息
		List<CourseChapterVo> chapterList = courseChapterService.getChapterInfoByCourseId(id);
		String userId = JwtUtils.getUserIdByToken(request);
		//获取用户课程购买状态
		Boolean buyStatus = orderClient.getBuyStatusByCourseId(userId, id);

		CourseDetailsVo detailsVo = new CourseDetailsVo();
		detailsVo.setDescription(courseDescription.getDescription());
		detailsVo.setChapter(chapterList);
		BeanUtils.copyProperties(course, detailsVo);

		detailsVo.setTeacherId(teacher.getId());
		detailsVo.setTeacherName(teacher.getName());
		detailsVo.setTeacherAvatar(teacher.getAvatar());
		detailsVo.setTeacherCareer(teacher.getCareer());
		detailsVo.setBuyStatus(buyStatus);
		return detailsVo;
	}

	@Transactional
	@Override
	public String saveCourseInfo(CourseInfoVo courseInfoVo) {
		//保存课程信息
		EduCourse course = new EduCourse();
		BeanUtils.copyProperties(courseInfoVo, course);
		save(course);
		//保存课程描述信息
		EduCourseDescription description = new EduCourseDescription();
		//需要获取mybatis-plus自动生成的id
		description.setId(course.getId());
		description.setDescription(courseInfoVo.getDescription());
		courseDescriptionService.save(description);
		return course.getId();
	}

	@Override
	public void updateCourseInfo(CourseInfoVo courseInfoVo) {
		//保存课程信息
		EduCourse course = new EduCourse();
		BeanUtils.copyProperties(courseInfoVo, course);
		updateById(course);
		//保存课程描述信息
		EduCourseDescription description = new EduCourseDescription();
		BeanUtils.copyProperties(courseInfoVo, description);
		courseDescriptionService.updateById(description);
	}

	@Override
	public void updateCourseStatus(String courseId, String status) {
		LambdaUpdateWrapper<EduCourse> updateWrapper = new LambdaUpdateWrapper<>();
		updateWrapper.eq(EduCourse::getId, courseId);
		updateWrapper.set(EduCourse::getStatus, status);
		update(updateWrapper);
	}

}




