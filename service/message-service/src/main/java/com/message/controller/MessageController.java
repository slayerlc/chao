package com.message.controller;

import com.common.ResultMap;
import com.message.model.Message;
import com.message.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;

/**
 * @author lvchao
 * @date 2018/6/13
 */
@RestController
@RequestMapping(value = "message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping(value = "hello")
    public Object hello(){
        Message message = new Message();
        message.setContent("lvchao hello");
        message.setTime("下午一点");
        return new ResultMap().successResult(message);
    }

}
