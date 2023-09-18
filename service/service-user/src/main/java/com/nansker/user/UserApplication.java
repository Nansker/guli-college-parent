package com.nansker.user;

import com.nansker.base.exception.CustomException;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Nansker
 * @date 2023/9/18 12:41
 * @description TODO
 */
@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.nansker.user.mapper")
public class UserApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class);
	}
}
