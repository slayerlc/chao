package com.zuul.exception.handler;


import com.general.ResultMap;
import com.netflix.zuul.context.RequestContext;
import org.apache.http.HttpStatus;
import org.apache.http.entity.ContentType;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
    public ResultMap handlerError(HttpServletRequest request) {
        RequestContext ctx = RequestContext.getCurrentContext();
        Integer httpStatus = (Integer) request.getAttribute("javax.servlet.error.status_code");
        //ctx.getResponse().setContentType(ContentType.APPLICATION_JSON.toString());
        if(httpStatus == HttpStatus.SC_NOT_FOUND){
            return new ResultMap(httpStatus, false,"页面不存在");
        }
        if(httpStatus == HttpStatus.SC_UNAUTHORIZED){
            return new ResultMap(httpStatus, false,"权限不足,拒接访问.");
        }
        return new ResultMap(httpStatus, false, ctx.getThrowable().getCause().getCause().getMessage());
    }
}
