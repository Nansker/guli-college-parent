package com.nansker.oss.qiniu.controller;

import com.nansker.commonutils.result.ResultData;
import com.nansker.oss.config.QiniuYunConfig;
import com.nansker.oss.qiniu.domain.CustomPutRet;
import com.nansker.oss.qiniu.domain.FileType;
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

    @PostMapping("/upload/avatar")
    public ResultData uploadImage(@RequestParam(value = "file") MultipartFile file) {
        CustomPutRet customPutRet = qiniuYunService.uploadFile(FileType.AVATAR,file);
        return ResultData.ok().data(customPutRet);
    }

    @PostMapping("/upload/course/video")
    public ResultData uploadCourseCover(@RequestParam(value = "file") MultipartFile file) {
        CustomPutRet customPutRet = qiniuYunService.uploadFile(FileType.COURSE_VIDEO,file);
        return ResultData.ok().data(customPutRet);
    }

    @PostMapping("/upload/course/cover")
    public ResultData uploadCourseVideo(@RequestParam(value = "file") MultipartFile file) {
        CustomPutRet customPutRet = qiniuYunService.uploadFile(FileType.COURSE_COVER,file);
        return ResultData.ok().data(customPutRet);
    }

    @GetMapping("/baseUrl")
    public ResultData getQiiuBaseUrl(){
        return ResultData.ok().data(qiniuYunConfig.getUrl());
    }
}
