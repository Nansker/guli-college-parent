package com.nansker.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nansker.entity.edu.EduCourseChapter;
import com.nansker.entity.edu.EduCourseVideo;
import com.nansker.entity.vo.CourseChapterVo;
import com.nansker.edu.mapper.EduCourseChapterMapper;
import com.nansker.edu.service.EduCourseChapterService;
import com.nansker.edu.service.EduCourseVideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nansker
 * @description 针对表【edu_course_chapter(课程)】的数据库操作Service实现
 * @createDate 2023-09-06 21:52:24
 */
@Service
public class EduCourseChapterServiceImpl extends ServiceImpl<EduCourseChapterMapper, EduCourseChapter> implements EduCourseChapterService {
	@Autowired
	EduCourseVideoService courseVideoService;

	@Override
	public List<CourseChapterVo> getChapterInfoByCourseId(String courseId) {
		//根据课程id获取章节信息
		LambdaQueryWrapper<EduCourseChapter> courseChapterQueryWrapper = new LambdaQueryWrapper<>();
		courseChapterQueryWrapper.eq(EduCourseChapter::getCourseId, courseId);
		courseChapterQueryWrapper.orderByAsc(EduCourseChapter::getSort);
		List<EduCourseChapter> courseChapters = list(courseChapterQueryWrapper);

		//根据课程id获取小节信息
		LambdaQueryWrapper<EduCourseVideo> courseVideoQueryWrapper = new LambdaQueryWrapper<>();
		courseVideoQueryWrapper.eq(EduCourseVideo::getCourseId, courseId);
		List<EduCourseVideo> courseVideos = courseVideoService.list(courseVideoQueryWrapper);
		courseVideoQueryWrapper.orderByAsc(EduCourseVideo::getSort);

		ArrayList<CourseChapterVo> courseChapterVos = new ArrayList<>();

		courseChapters.forEach(chapter -> {
			CourseChapterVo chapterVo = new CourseChapterVo();
			BeanUtils.copyProperties(chapter,chapterVo);

			ArrayList<EduCourseVideo> nodes = new ArrayList<>();
			courseVideos.forEach(node->{
				if (chapter.getId().equals(node.getChapterId())){
					nodes.add(node);
				}
				chapterVo.setChildren(nodes);
			});
			courseChapterVos.add(chapterVo);
		});

		return courseChapterVos;
	}

}




