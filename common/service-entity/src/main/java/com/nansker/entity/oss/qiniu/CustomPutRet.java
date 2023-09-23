package com.nansker.entity.oss.qiniu;

import lombok.Data;

/**
 * @author Nansker
 * @date 2023/9/14 18:41
 * @description TODO
 */
@Data
public class CustomPutRet {
	public String key; // 文件保存的 key
	public String hash; // 文件保存的 Etag
}
