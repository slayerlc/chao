package com.user.api;

import com.general.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping(value = "hello")
    public ResultMap hello(String messageJson){
        System.out.println(messageJson);
        String str = "机会已经给你了，你自己不争气。";
        return new ResultMap().successResult(str);
    }

}
