package com.common;

import com.common.constant.HttpStatus;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

/**
 * @Autor lvchao
 * @date 2018/6/2
 */
public class ResultMap {

    public Date time;

    public Integer status_code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Object data;

    public Boolean status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String error;

    public ResultMap(Integer status_code,boolean status, String error) {
        this.time = new Date();
        this.status = status;
        this.status_code = status_code;
        this.error = error;
    }

    public ResultMap(Object message) {
        this.time = new Date();
        this.status = true;
        this.status_code = HttpStatus.SC_OK;
        this.data = message;
    }

    public ResultMap(){};

    public ResultMap successResult(Object message){
        this.time = new Date();
        this.status = true;
        this.status_code = HttpStatus.SC_OK;
        this.data = message;
        return this;
    }

    public ResultMap errorResult(Integer status_code,boolean status, String error){
        this.time = new Date();
        this.status = status;
        this.status_code = status_code;
        this.error = error;
        return this;
    }
}

