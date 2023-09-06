package com.nansker.edu.domain.dto;

import com.nansker.edu.domain.EduTeacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Nansker
 * @date 2023/8/15 11:06
 * @description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EduTeacherDto extends EduTeacher {
    private int pageNum;
    private int pageSize;
}
