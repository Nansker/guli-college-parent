package com.nansker.oss.qiniu.domain;

/**
 * @author Nansker
 * @date 2023/8/23 15:25
 * @description TODO
 */
public class MyPutRet {
    public String key; // 文件保存的 key
    public String hash; // 文件保存的 Etag
    public String bucket; // 文件保存的 bucket
    public long fsize; // 文件的大小，单位：B
}
