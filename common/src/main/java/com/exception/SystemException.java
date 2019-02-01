package com.exception;

/**
 * @Author: lvchao
 * @Date: 2019-02-01 11:30
 * @Email:641819417@qq.com
 */
public class SystemException  extends RuntimeException{

    public SystemException() {
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
