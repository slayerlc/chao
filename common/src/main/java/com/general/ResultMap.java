package com.general;

import com.general.constant.HttpStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Autor lvchao
 * @date 2018/6/2
 */
@Setter
@Getter
public class ResultMap {

    private Date time;

    private Integer status_code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    private Boolean status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String error;

    public ResultMap(Integer status_code,boolean status, String error) {
        this.time = new Date();
        this.status = status;
        this.status_code = status_code;
        this.error = error;
    }

    public ResultMap(Object data) {
        this.time = new Date();
        this.status = true;
        this.status_code = HttpStatus.SC_OK;
        this.data = data;
    }

    public ResultMap(){};
}

