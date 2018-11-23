/*
package com.zuul.shiro.realm;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fdc.home.decrest.api.interceptor.RemoteException;
import com.fdc.home.decrest.api.util.PublicToolService;
import com.fdc.home.decrest.inter.constant.Constant;
import com.fdc.home.decrest.inter.exception.BusinessException;
import com.fdc.home.decrest.inter.model.DecPermission;
import com.fdc.home.decrest.inter.model.DecRole;
import com.fdc.home.decrest.inter.model.DecUser;
import com.fdc.home.decrest.inter.service.DecUserService;
import com.fdc.userid.convertor.IdDecoderUtil;
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

*/
/**
 * @Author: lvchao
 * @Date: 2018-08-07 9:51
 *//*

@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Value("${fdcApi_routerRest_uc}")
    private String fdcApiRouterRest;

    @Autowired
    DecUserService decUserService;

    */
/**
     * 授权认证
     *
     * @param principalCollection
     * @return
     *//*

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        DecUser userInfo = (DecUser) principalCollection.getPrimaryPrincipal();
        String userId = userInfo.getUserId();
        //获取用户权限  TODO 这里可以改成从redis获取
        DecUser decUser = decUserService.findByUserId(userId);
        if(decUser == null){
            throw new BusinessException("用户不存在");
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        //设置用户角色和权限
        Set<String> roleSigns = new HashSet<>();
        Set<String>  permissionSigns = new HashSet<>();

        Set<DecRole> roles = decUser.getDecRoleSet();
        //取出用户所有角色
        for(DecRole role : roles){
            roleSigns.add(role.getRoleSign());
            Set<DecPermission> permissions = role.getDecPermissionSet();
            //取出用户所有权限
            for(DecPermission permission : permissions){
                permissionSigns.add(permission.getPermissionSign());
            }
        }
        simpleAuthorizationInfo.setRoles(roleSigns);
        simpleAuthorizationInfo.setStringPermissions(permissionSigns);
        //将权限信息封装到AuthorizationInfo中，并返回
        return simpleAuthorizationInfo;
    }

    */
/**
     * 身份验证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     *//*

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        char[] c = token.getPassword();
        if(c == null || StringUtils.isEmpty(username)){
            throw new RemoteException(Constant.ErrorMessage.LoginFail);
        }
        String password = new String(c);
        Map<String, String> params = new HashMap<>();
        params.put("method", "ucaction.login.normal.login");
        params.put("loginName", username);
        params.put("userPasswd", password);

        //调用登录接口
        JSONObject jsonObject = JSON.parseObject(PublicToolService.setPostRequestURL(fdcApiRouterRest, params));
        log.info("登录返回信息 loginInfo = {}",jsonObject);
        JSONObject data =  jsonObject.getJSONObject("login_normal_login_response");

        if ( data != null) {
            JSONObject userInfo = data.getJSONObject("data");
            String userId = IdDecoderUtil.decodeIfNeeded(userInfo.getString("userid"));
            DecUser decUser = decUserService.findByUserId(userId);
            if(decUser == null){
                throw new BusinessException("用户不存在");
            }
            return new SimpleAuthenticationInfo(decUser, password, getName());
        }else{
            throw new RemoteException(Constant.ErrorMessage.LoginFail);
        }
      */
/*  return new SimpleAuthenticationInfo(new DecUser(), 123456, getName());*//*

    }
}
*/
