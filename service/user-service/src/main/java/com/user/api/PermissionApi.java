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

    @GetMapping(value = "getAll")
    public ResultMap getAll(){
        return new ResultMap(permissionService.getAll());
    }

    @PostMapping(value = "setPermission")
    public ResultMap setPermission(@RequestBody Permission permission){
        return new ResultMap(permissionService.addPermission(permission));
    }
}
