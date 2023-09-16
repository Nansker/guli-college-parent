package com.nansker.commonutils.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Nansker
 * @date 2023/8/8 4:57
 * @description TODO
 */
@Data
public class ResultData<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    private ResultData(){}

    public static ResultData ok(){
        ResultData resultData = new ResultData();
        resultData.setCode(ResultCode.SUCCESS);
        resultData.setMessage("操作成功");
        return resultData;
    }

    public static ResultData error(){
        ResultData resultData = new ResultData();
        resultData.setCode(ResultCode.ERROR);
        resultData.setMessage("操作失败");
        return resultData;
    }

    public ResultData code(Integer code){
        this.setCode(code);
        return this;
    }
    public ResultData message(String message){
        this.setMessage(message);
        return this;
    }

    public ResultData data(T data){
        this.setData(data);
        return this;
    }
}
