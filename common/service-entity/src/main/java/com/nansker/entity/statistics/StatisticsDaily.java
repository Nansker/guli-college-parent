package com.nansker.entity.statistics;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 网站统计日数据
 * @TableName statistics_daily
 */
@TableName(value ="statistics_daily")
@Data
public class StatisticsDaily implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "`id`", type = IdType.ASSIGN_ID)
    private String id;

    /**
     * 统计日期
     */
    private String dateCalculated;

    /**
     * 注册人数
     */
    private Integer registerNum;

    /**
     * 登录人数
     */
    private Integer loginNum;

    /**
     * 每日播放视频数
     */
    private Integer videoViewNum;

    /**
     * 每日新增课程数
     */
    private Integer courseNum;

    /**
     * 创建时间
     */
    @TableField(value = "`gmt_create`", fill = FieldFill.INSERT)
    private Date gmtCreate;

    /**
     * 更新时间
     */
    @TableField(value = "`gmt_modified`", fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}