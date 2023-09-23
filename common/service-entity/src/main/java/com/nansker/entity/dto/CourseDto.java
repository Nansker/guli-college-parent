package com.nansker.entity.dto;

import com.nansker.entity.edu.EduCourse;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Nansker
 * @date 2023/9/13 19:15
 * @description TODO
 */
@Data
public class CourseDto extends EduCourse implements Serializable {
	private int pageNum;
	private int pageSize;
}
