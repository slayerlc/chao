package com.exception;

/**
 * @Author: lvchao
 * @Date: 2019-01-04 10:26
 * @Email:641819417@qq.com
 */
public class UserException extends RuntimeException{

    public UserException() {
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }
}
