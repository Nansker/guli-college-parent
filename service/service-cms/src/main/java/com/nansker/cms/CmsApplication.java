package com.nansker.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author Nansker
 * @date 2023/9/15 15:19
 * @description TODO
 */
@SpringBootApplication
//开启缓存
@EnableCaching
@MapperScan("com.nansker.cms.mapper")
public class CmsApplication {
	public static void main(String[] args) {
		SpringApplication.run(CmsApplication.class);
	}
}
