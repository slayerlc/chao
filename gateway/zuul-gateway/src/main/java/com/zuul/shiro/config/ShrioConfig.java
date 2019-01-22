package com.zuul.shiro.config;

import com.zuul.shiro.realm.UserRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author: lvchao
 * @Date: 2018-12-12 9:20
 * @Email:641819417@qq.com
 */

@Configuration
public class ShrioConfig {

    @Bean
    public ShiroFilterFactoryBean ShiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/user-service/user/login");
        //shiroFilterFactoryBean.setSuccessUrl("");
        Map<String,String> map = new HashMap<>();
        map.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        return null;
    }

    @Bean
    public Realm getShiroRealm(){
        UserRealm myShiroRealm = new UserRealm();
        return myShiroRealm;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        // 注入 Realm 实现类，实现自己的登录逻辑
        securityManager.setRealm(getShiroRealm());
        return securityManager;
    }

    //加入注解的使用，不加入这个注解不生效
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
