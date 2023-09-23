package com.nansker.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nansker.base.exception.CustomException;
import com.nansker.entity.order.Order;
import com.nansker.entity.user.SysMember;
import com.nansker.entity.vo.CourseDetailsVo;
import com.nansker.order.client.EduClient;
import com.nansker.order.client.UserClient;
import com.nansker.order.mapper.OrderMapper;
import com.nansker.order.service.OrderService;
import com.nansker.order.utils.OrderNoUtil;
import com.nansker.utils.security.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Nansker
 * @description 针对表【order(订单)】的数据库操作Service实现
 * @createDate 2023-09-22 16:11:23
 */
@Slf4j
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
	@Autowired
	UserClient userClient;
	@Autowired
	EduClient eduClient;

	@Override
	public String createOrder(HttpServletRequest request, String courseId) {
		//获取用户id
		String userId = JwtUtils.getUserIdByToken(request);
		if (StringUtils.isEmpty(userId)) {
			throw new CustomException("用户未登录");
		}
		//根据用户id获取用户信息,远程调用服务
		SysMember member = userClient.getUserInfoById(userId);
		//获取课程信息
		CourseDetailsVo courseDetails = eduClient.getCourseDetails(courseId);

		Order order = new Order();
		//生成订单号
		order.setOrderNo(OrderNoUtil.getOrderNo());
		//设置会员信息
		order.setMemberId(member.getId());
		order.setNickname(member.getNickname());
		order.setEmail(!member.getEmail().isEmpty() ? member.getEmail() : "未知信息");
		//设置课程信息
		order.setCourseId(courseDetails.getId());
		order.setCourseTitle(courseDetails.getTitle());
		order.setCourseCover(courseDetails.getCover());
		order.setTotalFee(courseDetails.getPrice());
		order.setTeacherName(courseDetails.getTeacherName());
		//TODO 设置支付信息
		order.setStatus(0);
		//0 微信支付
		order.setPayType(1);
		order.setIsDeleted(1);
		//保存订单信息
		save(order);
		return order.getOrderNo();
	}

	@Override
	public Order getOrderByNo(String orderNo) {
		Order order = getOne(new LambdaQueryWrapper<Order>().eq(Order::getOrderNo, orderNo));
		return order;
	}

	@Override
	public void updateOrderStatus(String orderId, String status) {
		LambdaUpdateWrapper<Order> updateWrapper = new LambdaUpdateWrapper<>();
		updateWrapper.eq(Order::getId, orderId);
		updateWrapper.set(Order::getStatus, status);
		update(updateWrapper);
	}

}
