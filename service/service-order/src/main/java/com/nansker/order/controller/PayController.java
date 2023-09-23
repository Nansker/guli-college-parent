package com.nansker.order.controller;

import com.nansker.order.service.PayLogService;
import com.nansker.utils.result.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Nansker
 * @date 2023/9/22 17:00
 * @description TODO
 */
@RestController
@RequestMapping("/order/pay")
public class PayController {
	@Autowired
	PayLogService payLogService;

	@GetMapping("/code/{orderNo}")
	public ResultData createPayCode(@PathVariable String orderNo) {
		Map resultMap = payLogService.createPayCode(orderNo);
		return ResultData.ok().data(resultMap);
	}

	@GetMapping("/status/{orderNo}")
	public ResultData getPayStatus(@PathVariable String orderNo) {
		Map<String, String> resultMap = payLogService.getPayStatus(orderNo);
		if (resultMap == null) {
			return ResultData.error().message("支付出现问题,请稍后再试");
		}
		if (resultMap.get("trade_state").equals("SUCCESS")) {
			//添加支付记录，更新订单状态
			payLogService.updateOrderStatus(resultMap);
		}
		return ResultData.ok().data(resultMap.get("trade_state"));
	}

}
