package com.nansker.utils.result;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author Nansker
 * @date 2023/8/15 11:13
 * @description TODO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResultData implements Serializable {
    private List rows;
    private Long size;
    private Long total;
    public PageResultData(Page page){
        setRows(page.getRecords());
        setSize(page.getSize());
        setTotal(page.getTotal());
    }
}
