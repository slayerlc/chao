package com.message.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.message.model.Message;
import com.message.service.RestTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: lvchao
 * @Date: 2018-08-03 10:34
 */
@Service
@Slf4j
public class RestTemplateServiceImpl implements RestTemplateService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${restUrl.userServiceRest}")
    private String userServiceUrl;

    public Object userHello(Message message) {
        JSONObject json = restTemplate.postForObject(userServiceUrl + "/user/hello", message, JSONObject.class);
        return json.get("data");
    }
}
