package com.nansker.edu.domain.dto;

import com.nansker.edu.domain.EduSubject;
import lombok.Data;

/**
 * @author Nansker
 * @date 2023/8/26 23:18
 * @description TODO
 */
@Data
public class EduSubjectDto extends EduSubject {
    private int pageNum;
    private int pageSize;
}
