package com.zuul.shiro.realm;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.exception.UserException;
import com.general.constant.CueConstant;
import com.general.constant.HttpStatus;
import com.zuul.service.RestTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;


/**
 * @Author: lvchao
 * @Date: 2018-08-07 9:51
 */


@Slf4j
public class UserRealm extends AuthorizingRealm {

   /* @Value("${fdcApi_routerRest_uc}")
    private String fdcApiRouterRest;*/

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
        JSONObject userJson = (JSONObject) principalCollection.getPrimaryPrincipal();
        JSONArray permissions = userJson.getJSONArray("permissionSet");
        JSONArray roles = userJson.getJSONArray("roleSet");
        JSONArray organizations = userJson.getJSONArray("organizationSet");

        //设置用户角色和权限
        Set<String> permissionSigns = new HashSet<>();
        Set<String> roleSigns = new HashSet<>();
        Set<String> organizationSigns = new HashSet<>();

        //设置用户所有权限
        for (int i = 0; i < permissions.size(); i++) {
            permissionSigns.add(permissions.getJSONObject(i).getString("permissionSign"));
        }
        //设置用户所有角色
        for (int i = 0; i < roles.size(); i++) {
            roleSigns.add(roles.getJSONObject(i).getString("roleSign"));
        }
        //设置用户所属组织下面所拥有的角色和权限
        for (int i = 0; i < organizations.size(); i++) {
            JSONObject organization = organizations.getJSONObject(i);
            //设置组织权限标签
            organizationSigns.add(organization.getString("orgSign"));
            JSONArray orgRoles = organization.getJSONArray("roleSet");
            JSONArray orgPermissions = organization.getJSONArray("permissionSet");
            for (int r = 0; r < orgRoles.size(); r++) {
                permissionSigns.add(orgRoles.getJSONObject(i).getString("roleSign"));
            }
            for (int p = 0; p < orgPermissions.size(); p++) {
                roleSigns.add(orgPermissions.getJSONObject(i).getString("permissionSign"));
            }
        }

        //添加用户所有的角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roleSigns);
        simpleAuthorizationInfo.addRoles(organizationSigns);
        simpleAuthorizationInfo.setStringPermissions(permissionSigns);
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
        if (c == null || c.length <= 0 || StringUtils.isEmpty(account)) {
            throw new UserException(CueConstant.User.UnLogin);
        }
        String password = new String(c);
        JSONObject jsonObject = restTemplateService.userLogin(account, password);
        if (jsonObject.getString("code").equals(HttpStatus.SC_INTERNAL_SERVER_ERROR)) {
            log.error("UserService.UserApi.userLogin :{}",jsonObject.getString("error"));
            throw new UserException(jsonObject.getString("error"));
        }
        JSONObject userJson = jsonObject.getJSONObject("data");
        return new SimpleAuthenticationInfo(userJson, password, getName());

    }
}


