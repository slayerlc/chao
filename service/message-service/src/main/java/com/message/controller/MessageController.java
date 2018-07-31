package com.message.controller;

import com.general.ResultMap;
import com.message.model.Message;
import com.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lvchao
 * @date 2018/6/13
 */
@RestController
@RequestMapping(value = "message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping(value = "sendMessage")
    public Object sendMessage(@RequestBody Message message){
        return new ResultMap().successResult(message);
    }

}
