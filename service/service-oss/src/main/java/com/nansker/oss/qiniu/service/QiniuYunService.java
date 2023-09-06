package com.nansker.oss.qiniu.service;

import com.nansker.commonutils.result.ResultData;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Nansker
 * @date 2023/8/21 20:27
 * @description TODO
 */
public interface QiniuYunService {
    ResultData uploadQNImage(MultipartFile file);
}
