package com.nansker.entity.order;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单
 *
 * @TableName order
 */
//fixme 字段必须全部加 ``,原因猜测为字段存在于 mysql 关键字撞名的情况
@TableName(value = "`guli_college`.`order`")
@Data
public class Order implements Serializable {
	/**
	 *
	 */
	@TableId(value = "`id`", type = IdType.ASSIGN_ID)
	private String id;

	/**
	 * 订单号
	 */
	@TableField("`order_no`")
	private String orderNo;

	/**
	 * 课程id
	 */
	@TableField("`course_id`")
	private String courseId;

	/**
	 * 课程名称
	 */
	@TableField("`course_title`")
	private String courseTitle;

	/**
	 * 课程封面
	 */
	@TableField("`course_cover`")
	private String courseCover;

	/**
	 * 讲师名称
	 */
	@TableField("`teacher_name`")
	private String teacherName;

	/**
	 * 会员id
	 */
	@TableField("`member_id`")
	private String memberId;

	/**
	 * 会员昵称
	 */
	@TableField("`nickname`")
	private String nickname;

	/**
	 * 会员手机
	 */
	@TableField("`email`")
	private String email;

	/**
	 * 订单金额（分）
	 */
	@TableField("`total_fee`")
	private BigDecimal totalFee;

	/**
	 * 支付类型（1：微信 2：支付宝）
	 */
	@TableField("`pay_type`")
	private Integer payType;

	/**
	 * 订单状态（0：未支付 1：已支付）
	 */
	@TableField("`status`")
	private Integer status;

	/**
	 * 逻辑删除 1（true）已删除， 0（false）未删除
	 */
	@TableField("`is_deleted`")
	private Integer isDeleted;

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