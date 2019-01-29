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

    private Integer code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;

    private Boolean status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object error;

    public ResultMap(Integer code,boolean status, Object error) {
        this.time = new Date();
        this.status = status;
        this.code = code;
        this.error = error;
    }

    public ResultMap(Object data) {
        this.time = new Date();
        this.status = true;
        this.code = HttpStatus.SC_OK;
        this.data = data;
    }

    public ResultMap(){};
}

