package com.nansker.entity.dto;

import com.nansker.entity.edu.EduTeacher;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Nansker
 * @date 2023/8/15 11:06
 * @description TODO
 */
@Data
public class TeacherDto extends EduTeacher implements Serializable {
    private int pageNum;
    private int pageSize;
}
