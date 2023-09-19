package com.nansker.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author Nansker
 * @date 2023/9/17 1:16
 * @description TODO
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class EmailApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class);
	}
}
