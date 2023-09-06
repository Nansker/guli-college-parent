package com.nansker.servicebase.exception;

import com.nansker.commonutils.result.ResultData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Nansker
 * @date 2023/8/8 5:11
 * @description 统一异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultData error(Exception e) {
        e.printStackTrace();
        return ResultData.error();
    }

}