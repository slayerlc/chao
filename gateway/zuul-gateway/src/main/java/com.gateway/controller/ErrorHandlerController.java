package com.gateway.controller;


import com.common.ResultMap;
import com.netflix.zuul.context.RequestContext;
import org.apache.http.HttpStatus;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这里针对网关异常统一处理
 * 各个微服务的异常在各自的微服务里处理
 *
 * @Author: lvchao
 * @Date: 2018-07-30 8:49
 */
@RestController
public class ErrorHandlerController implements ErrorController {


    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public ResultMap handlerError() {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.getResponse().setContentType("application/json; charset=utf8");
        return new ResultMap(HttpStatus.SC_INTERNAL_SERVER_ERROR, false, ctx.getThrowable().getCause().getMessage());
    }
}
