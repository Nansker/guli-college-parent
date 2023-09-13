package com.nansker.oss.qiniu.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.nansker.oss.config.QiniuYunConfig;
import com.nansker.oss.qiniu.domain.MyPutRet;
import com.nansker.oss.qiniu.service.QiniuYunService;
import com.qiniu.common.Region;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
		// 华南地区zone2，如果是其他地区的需要修改
		uploadManager = new UploadManager(new Configuration());
		auth = Auth.create(qiniuYunConfig.getAccessKey(), qiniuYunConfig.getSecretKey());
		// 根据命名空间生成的上传token
		bucketManager = new BucketManager(auth, new Configuration(Region.huanan()));
		token = auth.uploadToken(qiniuYunConfig.getBucketName());
	}

	@Override
	public MyPutRet uploadFile(String type, MultipartFile file) {
		String fileType = StringUtils.isNotEmpty(type) ? (type + "/") : "";
		try {
			//获取文件数据流
			byte[] fileBytes = file.getBytes();
			//获取文件原始名称
			String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
			//设置文件日期路径
			String datePath = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
			//设置文件最终路径
			String filename = fileType + datePath + "/" + UUID.randomUUID().toString().replace("-", "") + suffix;
			//上传文件
			Response response = uploadManager.put(fileBytes, filename, token);
			MyPutRet myPutRet = response.jsonToObject(MyPutRet.class);
			//TODO 返回的地址为七牛云文件全地址，待优化
			//fixme 返回 MyPutRet bucket=null, fsize=0 的问题
			myPutRet.setKey(qiniuYunConfig.getUrl() + "/" + myPutRet.getKey());
			log.info("uploadFile.myPutRet--" + myPutRet.toString());
			return myPutRet;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
