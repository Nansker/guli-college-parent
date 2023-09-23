package com.nansker.order.service;

import com.nansker.entity.order.PayLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
* @author Nansker
* @description 针对表【pay_log(支付日志表)】的数据库操作Service
* @createDate 2023-09-22 16:11:23
*/
public interface PayLogService extends IService<PayLog> {
	/**
	 * @author Nansker
	 * @date 2023/9/23 22:57
	 * @param orderNo 订单号
	 * @return java.util.Map
	 * @description 生成微信支付二维码
	*/
	Map createPayCode(String orderNo);
	/**
	 * @author Nansker
	 * @date 2023/9/24 0:13
	 * @param orderNo 订单号
	 * @return java.util.Map<java.lang.String,java.lang.String>
	 * @description 根据订单号查询订单状态
	*/
	Map<String, String> getPayStatus(String orderNo);

	/**
	 * @author Nansker
	 * @date 2023/9/24 0:22
	 * @param map
	 * @return void
	 * @description 更新订单状态
	*/
	void updateOrderStatus(Map<String, String> map);

}
