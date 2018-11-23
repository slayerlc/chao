/*
package com.zuul.shiro.session;

import com.alibaba.dubbo.common.utils.StringUtils;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

*/
/**
 * @Author: lvchao
 * @Date: 2018-09-27 14:25
 * @Email:641819417@qq.com
 *//*

public class MySessionManager extends DefaultWebSessionManager {

    private static final String JSESSIONID = "JSESSIONID";

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        String sessionId = WebUtils.toHttp(request).getParameter(JSESSIONID);
       */
/* HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String sessionId = httpServletRequest.getHeader("JSESSIONID");*//*

        if (StringUtils.isNotEmpty(sessionId)) {
            return sessionId;
        }else{
            //没有携带session则shiro默认的方式获取session
            return super.getSessionId(request, response);
        }
    }
}
*/
