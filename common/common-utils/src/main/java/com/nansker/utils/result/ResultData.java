package com.nansker.utils.result;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Nansker
 * @date 2023/8/8 4:57
 * @description 统一数据响应类
 */
@Data
public class ResultData<T> implements Serializable {
	private Integer code;
	private String message;
	private T data;

	private ResultData() {}

	/**
	 * @author Nansker
	 * @date 2023/9/18 0:42
	 * @return com.nansker.utils.result.ResultData
	 * @description 成功响应
	*/
	public static ResultData ok() {
		ResultData resultData = new ResultData();
		resultData.setCode(ResultCode.SUCCESS);
		resultData.setMessage("操作成功");
		return resultData;
	}
	/**
	 * @author Nansker
	 * @date 2023/9/18 0:42
	 * @return com.nansker.utils.result.ResultData
	 * @description 失败响应
	*/
	public static ResultData error() {
		ResultData resultData = new ResultData();
		resultData.setCode(ResultCode.ERROR);
		resultData.setMessage("操作失败");
		return resultData;
	}

	public ResultData code(Integer code) {
		this.setCode(code);
		return this;
	}

	public ResultData message(String message) {
		this.setMessage(message);
		return this;
	}

	public ResultData data(T data) {
		this.setData(data);
		return this;
	}
	/**
	 * @author Nansker
	 * @date 2023/9/18 0:43
	 * @param page
	 * @return com.nansker.utils.result.ResultData
	 * @description mybatis-plus 分页数据
	*/
    public ResultData pageData(Page page) {
        Map<String, Object> map = new HashMap<>();
        map.put("rows", page.getRecords());
        map.put("total", page.getTotal());
        map.put("size", page.getSize());
        map.put("current", page.getCurrent());
        this.setData((T) map);
        return this;
    }
}
