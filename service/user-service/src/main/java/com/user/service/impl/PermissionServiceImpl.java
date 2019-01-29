package com.user.service.impl;

import com.user.Repository.PermissionRepository;
import com.user.entity.Permission;
import com.user.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: lvchao
 * @Date: 2018-11-09 10:35
 * @Email:641819417@qq.com
 */
@Slf4j
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService{

    @Autowired
    PermissionRepository repository;
    /**
     * 查询所有权限
     * @return
     */
    @Override
    public List<Permission> getAll() {
        return repository.findAll();
    }

    @Override
    public Permission addPermission(Permission permission) {
        return repository.save(permission);
    }
}
