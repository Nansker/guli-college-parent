package com.nansker.order.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.wxpay.sdk.WXPayUtil;
import com.nansker.base.exception.CustomException;
import com.nansker.entity.order.Order;
import com.nansker.entity.order.PayLog;
import com.nansker.order.config.WXPayConfig;
import com.nansker.order.mapper.PayLogMapper;
import com.nansker.order.service.OrderService;
import com.nansker.order.service.PayLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Nansker
 * @description 针对表【pay_log(支付日志表)】的数据库操作Service实现
 * @createDate 2023-09-22 16:11:23
 */
@Slf4j
@Service
public class PayLogServiceImpl extends ServiceImpl<PayLogMapper, PayLog> implements PayLogService {
	@Autowired
	OrderService orderService;
	@Autowired
	RestTemplate restTemplate;

	@Override
	public Map createPayCode(String orderNo) {
		try {
			//查询订单信息
			Order order = orderService.getOrderByNo(orderNo);
			//使用Map生成二维码参数
			Map<String, String> wxParams = new HashMap<>();
			wxParams.put("appid", WXPayConfig.APP_ID);
			wxParams.put("mch_id", WXPayConfig.PARTNER_ID);//商户号
			wxParams.put("nonce_str", WXPayUtil.generateNonceStr());
			wxParams.put("body", order.getCourseTitle());
			wxParams.put("out_trade_no", order.getOrderNo());
			wxParams.put("total_fee", order.getTotalFee().multiply(new BigDecimal("100")).longValue() + "");
			wxParams.put("spbill_create_ip", WXPayConfig.SPBILL_CREATE_Ip);
			wxParams.put("trade_type", WXPayConfig.TRADE_TYPE);
			wxParams.put("notify_url", WXPayConfig.NOTIFY_URL);
			//将参数加密转换成XML格式
			String paramsXmlStr = WXPayUtil.generateSignedXml(wxParams, WXPayConfig.PARTNER_KEY);
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(MediaType.APPLICATION_XML);
			HttpEntity<String> httpEntity = new HttpEntity<>(paramsXmlStr, httpHeaders);
			ResponseEntity<String> response = restTemplate.postForEntity(WXPayConfig.PAY_URL, httpEntity, String.class);
			//解析数据
			Map<String, String> wxResultMap = WXPayUtil.xmlToMap(response.getBody());
			log.info("wxResultMap--"+wxResultMap);
			// 封装最终数据
			Map<String, String> resultMap = new HashMap<>();
			resultMap.put("outTradeNo", order.getOrderNo());
			resultMap.put("courseId", order.getCourseId());
			resultMap.put("totalFee", order.getTotalFee().toString());
			resultMap.put("resultCode", (String) wxResultMap.get("result_code"));
			resultMap.put("coder_url", (String) wxResultMap.get("code_url"));
			return resultMap;
		} catch (Exception e) {
			new CustomException(e.getMessage());
		}
		return null;
	}

	@Override
	public Map<String, String> getPayStatus(String orderNo) {
		try {
			Map<String, String> wxParams = new HashMap<>();
			wxParams.put("appid", WXPayConfig.APP_ID);
			wxParams.put("mch_id", WXPayConfig.PARTNER_ID);//商户号
			wxParams.put("nonce_str", WXPayUtil.generateNonceStr());
			wxParams.put("out_trade_no", orderNo);
			String paramsXmlStr = WXPayUtil.generateSignedXml(wxParams, WXPayConfig.PARTNER_KEY);
			//将参数加密转换成XML格式/
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.setContentType(MediaType.APPLICATION_XML);
			HttpEntity<String> httpEntity = new HttpEntity<>(paramsXmlStr, httpHeaders);
			ResponseEntity<String> response = restTemplate.postForEntity(WXPayConfig.ORDER_URL, httpEntity, String.class);
			//解析数据
			Map<String, String> wxResultMap = WXPayUtil.xmlToMap(response.getBody());
			log.info("wxResultMap--"+wxResultMap);
			return wxResultMap;
		} catch (Exception e) {
			new CustomException(e.getMessage());
		}
		return null;
	}

	@Transactional
	@Override
	public void updateOrderStatus(Map<String, String> map) {
		//获取订单号
		String orderNo = map.get("out_trade_no");
		//查询微信支付状态
		Order order = orderService.getOrderByNo(orderNo);
		//更新订单状态
		if (order.getStatus().intValue() == 1) {
			return;
		}
		order.setStatus(1);
		orderService.updateById(order);
		//添加微信支付记录
		PayLog payLog = new PayLog();
		payLog.setOrderNo(orderNo);
		payLog.setPayTime(new Date());
		payLog.setPayType(1);
		payLog.setTotalFee(payLog.getTotalFee());
		payLog.setTradeState(map.get("trade_state"));
		payLog.setTransactionId(map.get("transaction_id"));
		payLog.setAttr(JSONObject.toJSONString(map));
		save(payLog);
	}

}




