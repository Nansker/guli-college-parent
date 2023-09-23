package com.nansker.order.service;

import com.nansker.entity.order.Order;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
* @author Nansker
* @description 针对表【order(订单)】的数据库操作Service
* @createDate 2023-09-22 16:11:23
*/
public interface OrderService extends IService<Order> {

	/**
	 * @author Nansker
	 * @date 2023/9/22 17:41
	 * @param request
	 * @param courseId
	 * @return void
	 * @description 创建用户订单
	*/
	String createOrder(HttpServletRequest request, String courseId);
	/**
	 * @author Nansker
	 * @date 2023/9/22 22:02
	 * @param orderNo 订单号
	 * @return com.nansker.entity.order.Order
	 * @description 根据订单号查询订单信息
	*/
	Order getOrderByNo(String orderNo);

	/**
	 * @author Nansker
	 * @date 2023/9/23 21:26
	 * @param orderNo 订单号
	 * @param status
	 * @return void
	 * @description 修改订单状态
	*/
	void updateOrderStatus(String orderNo, String status);

}
