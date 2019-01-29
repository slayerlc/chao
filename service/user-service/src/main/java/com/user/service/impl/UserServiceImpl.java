package com.user.service.impl;

import com.exception.UserException;
import com.general.constant.CueConstant;
import com.md5.MD5Encrypt;
import com.user.Repository.UserRepository;
import com.user.entity.User;
import com.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @Author: lvchao
 * @Date: 2018-11-07 10:08
 * @Email:641819417@qq.com
 */
@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 添加用户信息
     *
     * @param user
     * @return
     */
    @Override
    public User addUser(User user) {
        User repeat = userRepository.findUserByAccount(user.getAccount());
        if (repeat != null) {
            log.error(CueConstant.User.AccountNotExist + "account = {}", repeat.getAccount());
            throw new UserException(CueConstant.User.AccountExist);
        }
        String salt = UUID.randomUUID().toString();
        user.setPassword(MD5Encrypt.md5(user.getPassword(), salt));
        user.setSalt(salt);
        return userRepository.save(user);
    }

    /**
     * 根据账号查询用户信息
     *
     * @param account
     * @return
     */
    @Override
    public User findUserByAccount(String account) {
        User user = userRepository.findUserByAccount(account);
        if (user == null) {
            log.error(CueConstant.User.AccountNotExist + "account = {}", account);
            throw new UserException(CueConstant.User.AccountNotExist);
        }
        return user;
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    /**
     * 根据账号密码查找用户信息
     *
     * @param account
     * @param password
     * @return
     */
    @Override
    public User findUserByAccountAndPassword(String account, String password) {
        User user = findUserByAccount(account);
        user = userRepository.findUserByAccountAndPassword(account, MD5Encrypt.md5(password, user.getSalt()));
        if (user == null) {
            log.error(CueConstant.User.passwordError + "password = {}", password);
            throw new UserException(CueConstant.User.passwordError);
        }
        return user;
    }
}
