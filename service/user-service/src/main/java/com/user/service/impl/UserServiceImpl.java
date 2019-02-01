package com.user.service.impl;

import com.exception.UserException;
import com.general.constant.CueConstant;
import com.md5.MD5Encrypt;
import com.user.Repository.UserRepository;
import com.user.entity.Permission;
import com.user.entity.User;
import com.user.service.PermissionService;
import com.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

/**
 * @Author: lvchao
 * @Date: 2018-11-07 10:08
 * @Email:641819417@qq.com
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PermissionService permissionService;

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
        user.setPassword(encryptPassword(user.getPassword(), salt));
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
     *
     * @param id
     * @return
     */
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public Map<String, Object> findUserByPage(User user, Pageable pageable) {
        Page<User> userPage = userRepository.findAll((Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if (user != null) {
                if (StringUtils.isNotEmpty(user.getAccount())) {
                    predicateList.add(criteriaBuilder.like(root.get("account").as(String.class), "%" + user.getAccount() + "%"));
                }

                if (StringUtils.isNotEmpty(user.getNickName())) {
                    predicateList.add(criteriaBuilder.like(root.get("nickName").as(String.class), "%" + user.getNickName() + "%"));
                }

                if (StringUtils.isNotEmpty(user.getPhone())) {
                    predicateList.add(criteriaBuilder.like(root.get("phone").as(String.class), "%" + user.getPhone() + "%"));
                }

                if (user.getGender() != null) {
                    predicateList.add(criteriaBuilder.equal(root.get("gender").as(Integer.class), user.getGender()));
                }
            }
            return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
        }, pageable);

        Map<String, Object> result = new HashMap<>();
        result.put("userList", userPage.getContent());
        result.put("totalNum", userPage.getTotalElements());
        result.put("totalPage", userPage.getTotalPages());

        return result;
    }

    /**
     * 更新用户基本信息
     *
     * @param user
     * @return
     */
    @Override
    public User updateUser(User user) {
        User u = userRepository.findById(user.getId()).get();

        if (StringUtils.isNotEmpty(user.getPassword())) {
            String salt = UUID.randomUUID().toString();
            encryptPassword(user.getPassword(), salt);
        }
        u.setAge(user.getAge());
        //TODO 更新用户基本信息
        return userRepository.save(u);
    }

    /**
     * 更新用户 部门 角色 权限
     */
    public User updateAuthc(User user) {
        //TODO 更新用户 权限 角色 部门
        User u = userRepository.findById(user.getId()).get();

        Set permissionIds = new HashSet();
        for (Permission p : user.getPermissionSet()) {
            permissionIds.add(p.getId());
        }
        u.setPermissionSet(new HashSet<Permission>(permissionService.getAllList(permissionIds)));
        return userRepository.save(u);
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

    public String encryptPassword(String password, String salt) {
        return MD5Encrypt.md5(password, salt);
    }
}
