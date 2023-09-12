package com.nansker.edu.domain.dto;

import com.nansker.edu.domain.EduTeacher;
import lombok.Data;

/**
 * @author Nansker
 * @date 2023/8/15 11:06
 * @description TODO
 */
@Data
public class TeacherDto extends EduTeacher {
    private int pageNum;
    private int pageSize;
}
