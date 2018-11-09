package com.user.exception.handler;

import com.general.ResultMap;
import com.general.constant.HttpStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        return new ResultMap(HttpStatus.SC_INTERNAL_SERVER_ERROR,false,e.getMessage());
    }

    /**
     * 参数验证异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultMap validateException(Exception e){
        ConstraintViolationException constraintViolationException = (ConstraintViolationException) e;
        Set<ConstraintViolation<?>> set = constraintViolationException.getConstraintViolations();
        String[] reason = new String[set.size()];
        int i = 0;
        for(ConstraintViolation constraintViolation : set){
            reason[i] = constraintViolation.getMessage();
            i++;
        }
        return new ResultMap(HttpStatus.SC_INTERNAL_SERVER_ERROR,false,reason);
    }
}
