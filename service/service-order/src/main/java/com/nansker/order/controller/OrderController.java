package com.nansker.order.controller;

import com.nansker.entity.order.Order;
import com.nansker.order.service.OrderService;
import com.nansker.utils.result.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Nansker
 * @date 2023/9/22 17:00
 * @description TODO
 */
@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderService orderService;

	@PostMapping("/create/{courseId}")
	public ResultData createOrder(HttpServletRequest request, @PathVariable String courseId) {
		String orderNo = orderService.createOrder(request, courseId);
		return ResultData.ok().data(orderNo);
	}

	@GetMapping("/{orderNo}")
	public ResultData getOrderByNo(@PathVariable String orderNo) {
		Order order = orderService.getOrderByNo(orderNo);
		return ResultData.ok().data(order);
	}

}
