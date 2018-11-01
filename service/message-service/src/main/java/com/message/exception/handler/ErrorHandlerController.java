package com.message.exception.handler;


import com.general.ResultMap;
import com.general.constant.HttpStatus;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 404页面没找到
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
    public ResultMap handlerError(HttpServletRequest request){
        return new ResultMap(HttpStatus.SC_NOT_FOUND,false,"页面不存在");
    }
}
