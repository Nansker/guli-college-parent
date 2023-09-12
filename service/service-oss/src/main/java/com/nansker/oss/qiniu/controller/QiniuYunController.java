package com.nansker.oss.qiniu.controller;

import com.nansker.commonutils.result.ResultData;
import com.nansker.oss.config.QiniuYunConfig;
import com.nansker.oss.qiniu.domain.MyPutRet;
import com.nansker.oss.qiniu.service.QiniuYunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Nansker
 * @date 2023/8/22 13:58
 * @description TODO
 */
@RestController
@RequestMapping("/oss/qiniu")
public class QiniuYunController {
    @Autowired
    QiniuYunService qiniuYunService;
    @Autowired
    QiniuYunConfig qiniuYunConfig;
    @PostMapping("/image/upload")
    public ResultData uploadImage(@RequestParam(value = "file", required = false) MultipartFile file) {
        MyPutRet myPutRet = qiniuYunService.uploadQNImage(file);
        return ResultData.ok().data(myPutRet);
    }

    @GetMapping("/baseUrl")
    public ResultData getQiiuBaseUrl(){
        return ResultData.ok().data(qiniuYunConfig.getUrl());
    }
}
