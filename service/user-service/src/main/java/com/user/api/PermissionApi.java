package com.user.api;

import com.general.ResultMap;
import com.user.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
