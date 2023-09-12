package com.nansker.edu.domain.vo;

import com.nansker.edu.domain.EduCourseChapter;
import com.nansker.edu.domain.EduCourseVideo;
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
