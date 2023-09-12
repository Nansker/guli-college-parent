package com.nansker.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Nansker
 * @date 2023/8/7 5:38
 * @description TODO
 */
@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.nansker.edu.mapper")
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}