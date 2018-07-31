package com.message.exception.handler;

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

    /**
     * 这里可以专门拦截自定义异常
     * @param e
     * @return
     */
    /*@ExceptionHandler(ServiceException.class)
    public ResultMap ServiceException(Exception e) {
        return new ResultMap().errorResult(HttpStatus.SC_INTERNAL_SERVER_ERROR,false,e.getMessage());
    }*/
}