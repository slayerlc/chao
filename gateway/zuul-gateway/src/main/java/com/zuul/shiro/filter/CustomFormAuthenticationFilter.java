/*
package com.zuul.shiro.filter;

import com.alibaba.fastjson.JSON;
import com.fdc.platform.common.constant.ErrorConstant;
import com.fdc.platform.common.yfutil.ResponseUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

*/
/**
 * @Author: lvchao
 * @Date: 2018-08-07 16:44
 * @Email:641819417@qq.com
 *//*

public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        boolean flag = false;
        AuthenticationToken token = this.createToken(request, response);
        Subject subject = SecurityUtils.getSubject();
        try {
            //TODO 这里暂时直接让他去做登录认证。后面这里需要校验TOKEN是否有效,无效则去登录,有效则直接访问
            subject.login(token);
            flag = true;
        } catch (Exception e) {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().print(
                    JSON.toJSONString(ResponseUtil.getErrorMap(ErrorConstant.NHS_CODE, ErrorConstant.UC_SERVICE_UNAVAILABLE, e.getCause().getMessage())
                    ));
        }
        return flag;
    }
}
*/
