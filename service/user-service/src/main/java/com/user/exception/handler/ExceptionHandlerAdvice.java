package com.user.exception.handler;

import com.general.ResultMap;
import com.general.constant.HttpStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.TransactionSystemException;
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

    /**
     * 统一异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResultMap handleException(Exception e) {
        log.error("user-service error:{}",e.getMessage(),e);
        return new ResultMap(HttpStatus.SC_INTERNAL_SERVER_ERROR,false,e.getMessage());
    }

    /**
     * 参数验证异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultMap validateException(ConstraintViolationException e){
        Set<ConstraintViolation<?>> set = e.getConstraintViolations();
        String[] reason = new String[set.size()];
        int i = 0;
        for(ConstraintViolation constraintViolation : set){
            reason[i] = constraintViolation.getMessage();
            i++;
        }
        return new ResultMap(HttpStatus.SC_INTERNAL_SERVER_ERROR,false,reason);
    }

    /**
     * 在service层做数据库操作的时候 比如save()方法的时候 会抛出一个 ConstraintViolationException
     * 但是在事务层抛出的异常会包一层 TransactionSystemException 和 RollbackException
     * 所以这里判断如果是ConstraintViolationException 则直接用validateException()方法处理
     */
    @ExceptionHandler(TransactionSystemException.class)
    public ResultMap transactionException(TransactionSystemException e){
        if(e.getCause() != null && e.getCause().getCause() instanceof ConstraintViolationException){
            return validateException((ConstraintViolationException) e.getCause().getCause());
        }else{
            return handleException(e);
        }
    }

}
