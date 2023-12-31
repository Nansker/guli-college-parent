package com.nansker.entity.edu;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 讲师
 * @TableName edu_teacher
 */
@TableName(value ="edu_teacher")
@Data
public class EduTeacher implements Serializable {
    /**
     * 讲师ID
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 讲师姓名
     */
    private String name;

    /**
     * 讲师简介
     */
    private String intro;
    /**
     * 资历简介
     */
    private String career;
    /**
     * 头衔 1高级讲师 2首席讲师
     */
    private Object level;

    /**
     * 讲师头像
     */
    private String avatar;

    /**
     * 排序
     */
    private Object sort;

    /**
     * 逻辑删除 1（true）已删除， 0（false）未删除
     */
    private Integer isDeleted;

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