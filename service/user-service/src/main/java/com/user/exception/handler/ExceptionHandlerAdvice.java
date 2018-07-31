package com.user.exception.handler;

import com.general.ResultMap;
import com.general.constant.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 业务异常处理
 * @Author: lvchao
 * @Date: 2018-07-30 14:32
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    public ResultMap handleException(Exception e) {
        return new ResultMap().errorResult(HttpStatus.SC_INTERNAL_SERVER_ERROR,false,e.getMessage());
    }
}
