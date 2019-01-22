package com.resttemplate;


import com.alibaba.fastjson.JSONObject;
import com.modle.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: lvchao
 * @Date: 2018-12-11 14:35
 * @Email:641819417@qq.com
 */
@Service
public class UserRestTemplateService {

    @Autowired
    RestTemplate restTemplate;

    public JSONObject getPermissionList(String serviceUrl){
        return restTemplate.getForObject(serviceUrl+"/permission/getAll",JSONObject.class);
    }

    public JSONObject userLogin(String serviceUrl,String account, String password) {
        UserModel userModel = new UserModel(account,password);
        return restTemplate.postForObject(serviceUrl + "/user/login",userModel,JSONObject.class);
    }
}
