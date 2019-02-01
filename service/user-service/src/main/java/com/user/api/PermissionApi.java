package com.user.api;

import com.general.ResultMap;
import com.user.entity.Permission;
import com.user.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: lvchao
 * @Date: 2018-11-09 10:07
 * @Email:641819417@qq.com
 */
@RestController
@RequestMapping(value = "permission")
public class PermissionApi {

    @Autowired
    private PermissionService permissionService;

    /**
     * 查询所有权限
     * @return
     */
    @GetMapping(value = "getAll")
    public ResultMap getAll(){
        return new ResultMap(permissionService.getAll());
    }

    /**
     * 添加权限
     * @param permission
     * @return
     */
    @PostMapping(value = "setPermission")
    public ResultMap setPermission(@RequestBody Permission permission){
        return new ResultMap(permissionService.addPermission(permission));
    }

    /**
     * 更新权限
     * @param permission
     * @return
     */
    @PostMapping(value = "updatePermission")
    public ResultMap updatePermission(@RequestBody Permission permission){
        return new ResultMap(permissionService.updatePermission(permission));
    }

}
