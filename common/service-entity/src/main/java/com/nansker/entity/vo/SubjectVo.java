package com.nansker.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Nansker
 * @date 2023/8/27 16:25
 * @description TODO
 */
@Data
public class SubjectVo implements Serializable {
    private String id;
    private String title;
    private Date gmtCreate;
}
