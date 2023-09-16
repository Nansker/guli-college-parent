package com.nansker.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Nansker
 * @date 2023/9/15 15:19
 * @description TODO
 */
@SpringBootApplication
@MapperScan("com.nansker.cms.mapper")
public class CmsApplication {
	public static void main(String[] args) {
		SpringApplication.run(CmsApplication.class);
	}
}
