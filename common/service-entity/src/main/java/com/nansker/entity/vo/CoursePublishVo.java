package com.nansker.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Nansker
 * @date 2023/9/12 21:58
 * @description TODO
 */
@Data
public class CoursePublishVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String title;
	private String cover;
	private Integer lessonNum;
	private String subjectLevelOne;
	private String subjectLevelTwo;
	private String teacherName;
	private String status;
	private String description;
	private String price;//只用于显示
}
