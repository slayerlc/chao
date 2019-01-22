package com.zuul.shiro.realm;

import com.alibaba.fastjson.JSONObject;
import com.exception.UserException;
import com.general.constant.CueConstant;
import com.zuul.service.RestTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



/**
 * @Author: lvchao
 * @Date: 2018-08-07 9:51
 */


@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Value("${fdcApi_routerRest_uc}")
    private String fdcApiRouterRest;

    @Autowired
    private RestTemplateService restTemplateService;


/**
     * 授权认证
     *
     * @param principalCollection
     * @return
     */


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        return simpleAuthorizationInfo;
    }



/**
     * 身份验证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String account = token.getUsername();
        char[] c = token.getPassword();
        if (c == null || c.length >= 0 || StringUtils.isEmpty(account)) {
            throw new UserException(CueConstant.User.loginFail);
        }
        String password = new String();
        JSONObject jsonObject = restTemplateService.userLogin(account,password);
        return new SimpleAuthenticationInfo("", 123456, getName());

    }
}


