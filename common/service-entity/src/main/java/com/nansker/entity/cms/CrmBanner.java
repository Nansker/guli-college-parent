package com.nansker.entity.cms;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 首页banner表
 * @TableName crm_banner
 */
@TableName(value ="crm_banner")
@Data
public class CrmBanner implements Serializable {
    /**
     * ID
     */
    @TableId
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 图片地址
     */
    private String imageUrl;

    /**
     * 链接地址
     */
    private String linkUrl;

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