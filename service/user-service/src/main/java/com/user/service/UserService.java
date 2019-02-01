package com.user.service;

import com.user.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

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

    /**
     * 分页条件查询用户
     * @param user
     * @param pageable
     * @return
     */
    Map<String,Object> findUserByPage(User user, Pageable pageable);

    /**
     * 更新用户
     * @param user
     * @return
     */
    User updateUser(User user);
}
