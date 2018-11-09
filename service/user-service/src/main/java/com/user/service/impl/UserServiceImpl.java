package com.user.service.impl;

import com.exception.BusinessException;
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

    @Override
    public User addUser(User user) {
        User repeat = userRepository.findUserByAccount(user.getAccount());
        if (repeat != null) {
            throw new BusinessException("账号已存在！");
        }
        String salt = UUID.randomUUID().toString();
        user.setPassword(MD5Encrypt.md5(user.getPassword(),salt));
        user.setSalt(salt);
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUserByAccountAndPassword(String account, String password) {
        User user = userRepository.findUserByAccount(account);
        if(user == null){
            throw new BusinessException("账号不存在！");
        }
        user = userRepository.findUserByAccountAndPassword(account, MD5Encrypt.md5(password,user.getSalt()));
        if(user == null){
            throw new BusinessException("账号密码错误！");
        }
        return user;
    }
}
