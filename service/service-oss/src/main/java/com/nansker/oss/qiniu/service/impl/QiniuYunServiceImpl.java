package com.nansker.oss.qiniu.service.impl;

import com.nansker.commonutils.result.ResultData;
import com.nansker.oss.qiniu.domain.MyPutRet;
import com.nansker.oss.qiniu.service.QiniuYunService;
import com.nansker.oss.config.QiniuYunConfig;
import com.qiniu.common.Region;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author Nansker
 * @date 2023/8/21 20:29
 * @description TODO
 */
@Service
public class QiniuYunServiceImpl implements QiniuYunService {
    private QiniuYunConfig qiniuYunConfig;
    private UploadManager uploadManager;
    private String token;
    private Auth auth;
    private BucketManager bucketManager;
    public QiniuYunServiceImpl(QiniuYunConfig qiniuYunConfig) {
        this.qiniuYunConfig = qiniuYunConfig;
        init();
    }
    private void init() {
        // 我是华南地区的所以是zone2，如果是其他地区的需要修改
        uploadManager = new UploadManager(new Configuration(Region.huanan()));
        auth = Auth.create(qiniuYunConfig.getAccessKey(), qiniuYunConfig.getSecretKey());
        // 根据命名空间生成的上传token
        bucketManager = new BucketManager(auth, new Configuration(Region.huanan()));
        token = auth.uploadToken(qiniuYunConfig.getBucketName());
    }

    @Override
    public ResultData uploadQNImage(MultipartFile file) {
        try {
            //1、获取文件上传的流
            byte[] fileBytes = file.getBytes();
            //2、创建日期目录分隔
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String datePath = dateFormat.format(new Date());
            //3、获取文件名
            String originalFilename = file.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            String filename = datePath+"/"+ UUID.randomUUID().toString().replace("-", "")+ suffix;
            //4.上传文件
            Response response = uploadManager.put(fileBytes, filename, token);
            return ResultData.ok().data(response.jsonToObject(MyPutRet.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultData.ok();
    }

}
