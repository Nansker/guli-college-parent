package com.nansker.oss.qiniu.service;

import com.nansker.oss.qiniu.domain.CustomPutRet;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Nansker
 * @date 2023/8/21 20:27
 * @description TODO
 */
public interface QiniuYunService {
    /**
     * @author Nansker
     * @date 2023/9/13 23:24
     * @param type 文件分类
     * @param file 文件
     * @return com.nansker.oss.qiniu.domain.MyPutRet
     * @description TODO
    */
    CustomPutRet uploadFile(String type, MultipartFile file);
}
