package com.nansker.edu.domain.dto;

import com.nansker.edu.domain.EduSubject;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Nansker
 * @date 2023/8/26 23:18
 * @description TODO
 */
@Data
public class SubjectDto extends EduSubject implements Serializable {
    private int pageNum;
    private int pageSize;
}
