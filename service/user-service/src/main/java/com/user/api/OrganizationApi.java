package com.user.api;

import com.general.ResultMap;
import com.user.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lvchao
 * @Date: 2018-11-09 9:42
 * @Email:641819417@qq.com
 */
@RestController
@RequestMapping(value = "organization")
public class OrganizationApi {

    @Autowired
    OrganizationService organizationService;

    @GetMapping(value = "findAll")
    public ResultMap findAll(){
        return new ResultMap(organizationService.findAll());
    }
}
