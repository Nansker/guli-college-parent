package com.nansker.oss.qiniu.service;

import com.nansker.oss.qiniu.domain.MyPutRet;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Nansker
 * @date 2023/8/21 20:27
 * @description TODO
 */
public interface QiniuYunService {
    MyPutRet uploadQNImage(MultipartFile file);
}
