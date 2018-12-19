package com.user.service;

import com.user.entity.Permission;

import java.util.List;

/**
 * @Author: lvchao
 * @Date: 2018-11-09 10:35
 * @Email:641819417@qq.com
 */
public interface PermissionService {
    /**
     * 查询所有权限
     * @return
     */
    List<Permission> getAll();
}
