package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Autor lvchao
 * @date 2018/6/2
 */
@Controller
@RequestMapping(value = "hello")
public class HelloController {

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
