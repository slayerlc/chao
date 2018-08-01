package com.user.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lvchao
 * @date 2018/6/13
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    RestTemplate restTemplate;

    public String hello(){
        System.out.println("@@@@@@@@");
        return "user-service";
    }

}
