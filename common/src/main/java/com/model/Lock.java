package com.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: lvchao
 * @Date: 2018-10-12 16:49
 * @Email:641819417@qq.com
 */
@Getter
@Setter
public class Lock {

    String value;
    String key;

    public Lock() {
    }

    public Lock(String value, String key) {
        this.value = value;
        this.key = key;
    }

    public Lock(String key) {
        this.key = key;
    }
}
