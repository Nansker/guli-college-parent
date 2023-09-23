package com.nansker.entity.vo;

import com.nansker.entity.edu.EduCourseChapter;
import com.nansker.entity.edu.EduCourseVideo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Nansker
 * @date 2023/9/11 18:31
 * @description TODO
 */
@Data
public class CourseChapterVo extends EduCourseChapter implements Serializable {
	private List<EduCourseVideo> children;
}
