package com.zuul.shiro.filter;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.exception.SystemException;
import com.zuul.service.RestTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: lvchao
 * @Date: 2019-01-28 9:50
 * @Email:641819417@qq.com
 */
@Slf4j
public class MyShiroFilterFactoryBean extends ShiroFilterFactoryBean {

    @Autowired
    RestTemplateService restTemplateService;

    /**
     * 动态更新权限
     */
    public synchronized void updatePermission(){
        AbstractShiroFilter shiroFilter = null;
        try {
            shiroFilter = (AbstractShiroFilter) this.getObject();
        } catch (Exception e) {
            log.error("动态更新权限报错 shiroFilter = {}",shiroFilter);
            throw new SystemException("系统权限更新错误,请联系管理员.",e);
        }
        PathMatchingFilterChainResolver filterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
            DefaultFilterChainManager defaultFilterChainManager = (DefaultFilterChainManager) filterChainResolver.getFilterChainManager();
            //清空拦截器 和拦截工厂的储存 的权限
            defaultFilterChainManager.getFilterChains().clear();
            this.getFilterChainDefinitionMap().clear();
            //准备重新更新权限
            JSONObject jsonResources = restTemplateService.getPermissionList();
            JSONArray jsonArray = jsonResources.getJSONArray("data");
            for(int i = 0; i < jsonArray.size(); i++){
                JSONObject jsonPermission = jsonArray.getJSONObject(i);
                String authcSign = jsonPermission.getString("authcSign");
                String authcMode = jsonPermission.getString("authcMode");
                StringBuffer sb = new StringBuffer(authcMode);
                if(StringUtils.isNotEmpty(authcMode)){
                    sb.append(",").append(authcSign);
                }
                defaultFilterChainManager.createChain(jsonPermission.getString("permissionUrl"),sb.toString());
            }
            defaultFilterChainManager.createChain("/v1/user-service/user/login","anon");
            defaultFilterChainManager.createChain("/**","authc");
    }
}
