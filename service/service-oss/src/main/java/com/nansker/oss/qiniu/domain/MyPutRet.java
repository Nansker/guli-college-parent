package com.nansker.oss.qiniu.domain;

import lombok.Data;

/**
 * @author Nansker
 * @date 2023/8/23 15:25
 * @description TODO
 */
@Data
public class MyPutRet {
    /**
     * @author Nansker
     * @date 2023/9/14 0:43
     * @description 文件保存的 key
    */
    public String key;
    /**
     * @author Nansker
     * @date 2023/9/14 0:43
     * @description // 文件保存的 Etag
    */
    public String hash;
    /**
     * @author Nansker
     * @date 2023/9/14 0:44
     * @description 文件保存的 bucket
    */
    public String bucket;
    /**
     * @author Nansker
     * @date 2023/9/14 0:44
     * @description 文件的大小，单位：B
    */
    public long fsize;
}
