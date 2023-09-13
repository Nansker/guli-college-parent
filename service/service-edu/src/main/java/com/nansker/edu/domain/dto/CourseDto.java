package com.nansker.edu.domain.dto;

import com.nansker.edu.domain.EduCourse;
import lombok.Data;

/**
 * @author Nansker
 * @date 2023/9/13 19:15
 * @description TODO
 */
@Data
public class CourseDto extends EduCourse {
	private int pageNum;
	private int pageSize;
}
