package com.zuul.filter;

import com.alibaba.fastjson.JSONObject;
import com.general.ResultMap;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ZuulGatewayFilter extends ZuulFilter {

    public static final long expireTime = 3600000*24;

    /**
     * 过滤器类型 他决定在过滤器在请求的哪个生命周期中执行
     * 比如定义为pre代表 请求会在被路由之前执行
     * routing 在路由请求时间被调用
     * post 在routing 和error过滤器之后被调用
     * error 处理请求时发生错误时被调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序 在存在多个过滤器的时候根据返回值来依次执行
     * 数值越小优先级越高
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否需要被执行 直接返回true 过滤器对所有请求都有效
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * 这里我们通过ctx.setSendZuulResponse(false)
     * 令zuul过滤该请求,不对其进行路由，然后通过 ctx.setResponseStatusCode(401)设置其返回的错误码
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run(){
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest httpServletRequest = requestContext.getRequest();
        HttpServletResponse httpServletResponse = requestContext.getResponse();
        if (httpServletRequest.getRequestURI().equals("/v1/user-service/user/login") && login(httpServletRequest, httpServletResponse, requestContext)) {
            requestContext.setSendZuulResponse(false);
            Object userJson = SecurityUtils.getSubject().getPrincipal();
            requestContext.setResponseBody(JSONObject.toJSONString(new ResultMap(userJson)));
        }
        return null;
    }

    private boolean login(HttpServletRequest request, HttpServletResponse response, RequestContext context) {
        String username = request.getParameter("account");
        String password = request.getParameter("password");
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setTimeout(expireTime);
        subject.login(token);
        return true;
    }
}
