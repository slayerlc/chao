package com.user.service;

import com.user.entity.User;

import java.util.List;

/**
 * @Author: lvchao
 * @Date: 2018-11-07 10:08
 * @Email:641819417@qq.com
 */
public interface UserService {

    /**
     * 根据账号密码查找用户信息
     * @param account
     * @param password
     * @return
     */
    User findUserByAccountAndPassword(String account, String password);

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    User addUser(User user);

    /**
     * 根据账号查询用户信息
     * @param account
     * @return
     */
     User findUserByAccount(String account);

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    User findById(Long id);
}
