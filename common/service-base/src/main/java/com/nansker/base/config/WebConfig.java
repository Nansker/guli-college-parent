package com.nansker.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Nansker
 * @date 2023/8/13 7:36
 * @description WebMvc配置类
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    static final String ORIGINS[] = new String[] { "GET", "POST", "PUT", "DELETE" };
    /**
     * @author Nansker
     * @date 2023/9/19 0:40
     * @param registry
     * @return void
     * @description 解决跨域问题
    */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(false)
                .allowedMethods(ORIGINS)
                .maxAge(3600);
    }
}
