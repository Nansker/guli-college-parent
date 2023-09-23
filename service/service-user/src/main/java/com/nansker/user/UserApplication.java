package com.nansker.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Nansker
 * @date 2023/9/18 12:41
 * @description TODO
 */
@EnableTransactionManagement
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@MapperScan("com.nansker.user.mapper")
public class UserApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class);
	}
}
