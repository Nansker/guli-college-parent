package com.nansker.edu.domain.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Nansker
 * @date 2023/8/27 16:26
 * @description TODO
 */
@Data
public class SubjectNestedVo implements Serializable {
    private String id;
    private String title;
    private Date gmtCreate;
    private List<SubjectVo> children = new ArrayList<>();
}
