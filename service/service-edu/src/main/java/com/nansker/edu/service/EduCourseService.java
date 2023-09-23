package com.nansker.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nansker.entity.dto.CourseDto;
import com.nansker.entity.edu.EduCourse;
import com.nansker.entity.vo.CourseDetailsVo;
import com.nansker.entity.vo.CourseInfoVo;
import com.nansker.entity.vo.CoursePublishVo;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Nansker
 * @description 针对表【edu_course(课程)】的数据库操作Service
 * @createDate 2023-09-17 02:07:10
 */
public interface EduCourseService extends IService<EduCourse> {
	/**
	 * @param courseDto
	 * @return com.nansker.utils.result.PageResultData
	 * @author Nansker
	 * @date 2023/9/17 22:37
	 * @description 分页查询课程列表
	 */
	Page getCourseList(CourseDto courseDto);

	/**
	 * @author Nansker
	 * @date 2023/9/17 22:50
	 * @param id
	 * @return com.nansker.entity.vo.CoursePublishVo
	 * @description 获取课程发布信息
	 */
	CoursePublishVo getCoursePublishInfoById(String id);

	/**
	 * @param id
	 * @return com.nansker.commonutils.result.ResultData
	 * @author Nansker
	 * @date 2023/9/16 12:02
	 * @description 根据id获取课程详情及章节信息
	 */
	CourseDetailsVo getCourseDetailsById(@PathVariable String id);

	/**
	 * @param courseInfoVo
	 * @return java.lang.String
	 * @author Nansker
	 * @date 2023/9/17 22:52
	 * @description 保存课程信息，返回id
	 */
	String saveCourseInfo(CourseInfoVo courseInfoVo);

	/**
	 * @param courseInfoVo
	 * @return void
	 * @author Nansker
	 * @date 2023/9/17 22:52
	 * @description 更新课程信息
	 */
	void updateCourseInfo(CourseInfoVo courseInfoVo);

	/**
	 * @param courseId
	 * @param status
	 * @return void
	 * @author Nansker
	 * @date 2023/9/17 22:48
	 * @description 更新课程状态
	 */
	void updateCourseStatus(String courseId, String status);

}
