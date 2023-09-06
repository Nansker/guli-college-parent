package com.nansker.oss.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Nansker
 * @date 2023/8/21 16:06
 * @description TODO
 */
@Data
@Configuration
public class QiniuYunConfig {
    @Value("${qiniu.url}")
    private String url;
    @Value("${qiniu.accessKey}")
    private String AccessKey;
    @Value("${qiniu.secretKey}")
    private String SecretKey;
    @Value("${qiniu.bucketName}")
    private String BucketName;
}
