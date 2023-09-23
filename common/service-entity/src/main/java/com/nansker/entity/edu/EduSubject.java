package com.nansker.entity.edu;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程科目
 * @TableName edu_subject
 */
@TableName(value ="edu_subject")
@Data
public class EduSubject implements Serializable {
    /**
     * 课程类别ID
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 类别名称
     */
    private String title;

    /**
     * 父ID
     */
    private String parentId;

    /**
     * 排序字段
     */
    private Object sort;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}