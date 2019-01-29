package com.zuul.api;

import com.general.ResultMap;
import com.zuul.shiro.filter.MyShiroFilterFactoryBean;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lvchao
 * @Date: 2019-01-28 10:40
 * @Email:641819417@qq.com
 */
@RestController
@RequestMapping(value = "shiro")
public class ShiroController {

    @Autowired
    MyShiroFilterFactoryBean shiroFilter;

    /**
     * 当设置新的接口权限的时候 通过这个接口来更新shiro权限
     * @return
     */
    @GetMapping(value = "updatePermission")
    public ResultMap updatePermission(){
        shiroFilter.updatePermission();
        return new ResultMap("更新权限成功!");
    }
}
