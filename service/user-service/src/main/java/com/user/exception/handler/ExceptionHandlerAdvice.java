package com.user.exception.handler;

import com.general.ResultMap;
import com.general.constant.HttpStatus;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ExceptionHandlerAdvice {

    @ExceptionHandler(Exception.class)
    public ResultMap handleException(Exception e) {
        log.error("user-service error:{}",e.getMessage(),e);
        return new ResultMap().errorResult(HttpStatus.SC_INTERNAL_SERVER_ERROR,false,e.getMessage());
    }
}
