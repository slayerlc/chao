package com.exception;

/**
 * @Author: lvchao
 * @Date: 2018-11-09 9:06
 * @Email:641819417@qq.com
 */
public class BusinessException extends RuntimeException{

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }
}
