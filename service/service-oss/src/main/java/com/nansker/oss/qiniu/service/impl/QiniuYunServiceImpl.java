package com.nansker.oss.qiniu.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.nansker.oss.config.QiniuYunConfig;
import com.nansker.oss.qiniu.domain.CustomPutRet;
import com.nansker.oss.qiniu.service.QiniuYunService;
import com.qiniu.common.Region;
import com.qiniu.http.Response;
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

	public QiniuYunServiceImpl(QiniuYunConfig qiniuYunConfig) {
		this.qiniuYunConfig = qiniuYunConfig;
		init();
	}

	private void init() {
		// 华南地区zone2，如果是其他地区的需要修改
		//fixme 经常性报错 token 失效，导致文件上传失败,暂未找到解决办法
		Configuration configuration = new Configuration(Region.autoRegion());
		uploadManager = new UploadManager(configuration);
		auth = Auth.create(qiniuYunConfig.getAccessKey(), qiniuYunConfig.getSecretKey());
	}

	@Override
	public CustomPutRet uploadFile(String type, MultipartFile file) {
		String fileType = StringUtils.isNotEmpty(type) ? (type + "/") : "";
		// 根据命名空间生成的上传token
		//TODO 每次上传请求token,防止{"error":"expired token"}报错
		token = auth.uploadToken(qiniuYunConfig.getBucketName());
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
			CustomPutRet customPutRet = response.jsonToObject(CustomPutRet.class);
			//TODO 返回的地址为七牛云文件全地址，待优化
			customPutRet.setKey(qiniuYunConfig.getUrl() + "/" + customPutRet.getKey());
			return customPutRet;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
