package com.zuul.shiro.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: lvchao
 * @Date: 2018-12-12 9:20
 * @Email:641819417@qq.com
 */
@Configuration
public class ShrioConfig {

    @Bean
    public ShiroFilterFactoryBean ShiroFilter(SecurityManager securityManager){
        return null;
    }

    @Bean
    public Realm getShiroRealm(){
        UserRealm myShiroRealm = new UserRealm.java();
        return myShiroRealm;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        // 注入 Realm 实现类，实现自己的登录逻辑
        securityManager.setRealm(getShiroRealm());
        return securityManager;
    }
}
