package com.zuul.service;

import com.alibaba.fastjson.JSONObject;
import com.resttemplate.UserRestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: lvchao
 * @Date: 2018-12-11 14:42
 * @Email:641819417@qq.com
 */
@Service
public class RestTemplateService {

    @Value("${restUrl.userServiceRest}")
    private String userServiceUrl;

    @Autowired
    private UserRestTemplateService userRestTemplateService;

    public void getPermissionList(){
        JSONObject jsonObject = userRestTemplateService.getPermissionList(userServiceUrl);
    }
}
