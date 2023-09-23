package com.nansker.order.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Nansker
 * @date 2023/9/23 23:05
 * @description 微信支付配置类
 */
@Component
public class WXPayConfig implements InitializingBean {
	@Value("${wxpay.appid}")
	private String appid;
	@Value("${wxpay.partner-id}")
	private String partner;
	@Value("${wxpay.partner-key}")
	private String partnerKey;
	@Value("${wxpay.notify-url}")
	private String notifyUrl;
	@Value("${wxpay.pay-url}")
	private String payUrl;
	@Value("${wxpay.order-url}")
	private String orderUrl;
	@Value("${wxpay.trade-type}")
	private String tradeType;
	@Value("${wxpay.spbill-create-ip}")
	private String spbillCreateIp;

	public static String APP_ID;
	public static String PARTNER_ID;
	public static String PARTNER_KEY;
	public static String NOTIFY_URL;
	public static String PAY_URL;
	public static String ORDER_URL;
	public static String TRADE_TYPE;
	public static String SPBILL_CREATE_Ip;

	@Override
	public void afterPropertiesSet() throws Exception {
		APP_ID = appid;
		PARTNER_ID = partner;
		PARTNER_KEY = partnerKey;
		NOTIFY_URL = notifyUrl;
		PAY_URL = payUrl;
		ORDER_URL = orderUrl;
		TRADE_TYPE = tradeType;
		SPBILL_CREATE_Ip = spbillCreateIp;
	}

}
