package com.user.service;

import com.user.entity.User;

import java.util.List;

/**
 * @Author: lvchao
 * @Date: 2018-11-07 10:08
 * @Email:641819417@qq.com
 */
public interface UserService {

    User findUserByAccountAndPassword(String account, String password);

    User addUser(User user);

    List<User> findAll();
}
