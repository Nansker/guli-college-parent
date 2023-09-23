package com.nansker.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Nansker
 * @date 2023/9/22 20:32
 * @description TODO
 */
@Data
public class CourseDetailsVo implements Serializable {
	/**
	 * 课程id
	 */
	private String id;
	/**
	 * 课程标题
	 */
	private String title;
	/**
	 * 课程封面
	 */
	private String cover;
	/**
	 * 讲师id
	 */
	private String teacherId;
	/**
	 * 讲师姓名
	 */
	private String teacherName;
	/**
	 * 讲师头像
	 */
	private String teacherAvatar;
	/**
	 * 讲师头像
	 */
	private String teacherCareer;
	/**
	 * 课程价格
	 */
	private BigDecimal price;
	/**
	 * 总课时
	 */
	private Object lessonNum;
	/**
	 * 销售数量
	 */
	private Long buyCount;

	/**
	 * 浏览数量
	 */
	private Long viewCount;
	/**
	 * 课程描述
	 */
	private String description;
	/**
	 * 课程章节
	 */
	private List<CourseChapterVo> chapter;

}
