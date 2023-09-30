package com.nansker.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Nansker
 * @date 2023/9/22 16:04
 * @description TODO
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.nansker.order.mapper")
public class OrderApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}

}
