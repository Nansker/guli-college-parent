package com.nansker.base.exception;

import com.nansker.utils.result.ResultData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Nansker
 * @date 2023/8/8 5:11
 * @description 统一异常处理类
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResultData error(Exception e) {
        e.printStackTrace();
        return ResultData.error().message("服务器异常,请稍后再试");
    }

    @ExceptionHandler(CustomException.class)
    public ResultData runError(CustomException e) {
        e.printStackTrace();
        return ResultData.error().message(e.getMsg());
    }
}