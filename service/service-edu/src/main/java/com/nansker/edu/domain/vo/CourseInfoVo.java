package com.nansker.edu.domain.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author: Nansker
 * @date: 2023/9/7 13:31
 * @description: TODO
 */
@Data
public class CourseInfoVo implements Serializable {
    /**
     * 课程id
     */
    private String id;
    /**
     * 讲师id
     */
    private String teacherId;
    /**
     * 分类id
     */

    private String subjectParentId;
    /**
     * 课程专业id
     */
    private String subjectId;
    /**
     * 课程标题
     */
    private String title;
    /**
     * 课程价格
     */
    private BigDecimal price;
    /**
     * 总课时
     */
    private Integer lessonNum;
    /**
     * 课程封面
     */
    private String cover;
    /**
     * 课程简介
     */
    private String description;
}
