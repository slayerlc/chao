package com.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: lvchao
 * @Date: 2019-01-04 9:54
 * @Email:641819417@qq.com
 */
@Getter
@Setter
public class UserModel {

    String account;

    String password;

    public UserModel(String account, String password) {
        this.account = account;
        this.password = password;
    }
}
