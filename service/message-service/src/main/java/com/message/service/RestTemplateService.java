package com.message.service;

import com.alibaba.fastjson.JSONObject;
import com.general.ResultMap;
import com.message.model.Message;

/**
 * @Author: lvchao
 * @Date: 2018-08-03 10:35
 */
public interface RestTemplateService {

    Object userHello(Message message);
}
