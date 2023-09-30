package com.nansker.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nansker.entity.order.Order;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Nansker
 * @description 针对表【order(订单)】的数据库操作Service
 * @createDate 2023-09-22 16:11:23
 */
public interface OrderService extends IService<Order> {

	/**
	 * @param request
	 * @param courseId
	 * @return void
	 * @author Nansker
	 * @date 2023/9/22 17:41
	 * @description 创建用户订单
	 */
	String createOrder(HttpServletRequest request, String courseId);

	/**
	 * @param orderNo 订单号
	 * @return com.nansker.entity.order.Order
	 * @author Nansker
	 * @date 2023/9/22 22:02
	 * @description 根据订单号查询订单信息
	 */
	Order getOrderByNo(String orderNo);

	/**
	 * @param orderNo 订单号
	 * @param status
	 * @return void
	 * @author Nansker
	 * @date 2023/9/23 21:26
	 * @description 修改订单状态
	 */
	void updateOrderStatus(String orderNo, String status);

	/**
	 * @param userId
	 * @param courseId
	 * @return boolean
	 * @author Nansker
	 * @date 2023/9/24 16:16
	 * @description 根据课程id获取用户的购买状态
	 */
	Boolean getBuyStatusByCourseId(String userId, String courseId);

}
