package com.user.service.impl;

import com.exception.BusinessException;
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

    /**
     * 添加权限
     * @param permission
     * @return
     */
    @Override
    public Permission addPermission(Permission permission) {
        return repository.save(permission);
    }

    /**
     * 更新权限
     * @param permission
     * @return
     */
    @Override
    public Permission updatePermission(Permission permission) {
        Permission p = repository.findById(permission.getId()).get();
        if(p == null){
            log.error("PermissionId不存在,更新失败. permissionId = {}",permission.getId());
            throw new BusinessException("更新失败,权限不存在.");
        }
        return repository.save(permission);
    }
}
