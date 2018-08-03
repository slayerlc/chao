package com.message.api;

import com.general.ResultMap;
import com.message.amqp.MessageSend;
import com.message.model.Message;
import com.message.service.MessageService;
import com.message.service.RestTemplateService;
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

    @Autowired
    MessageSend messageSend;

    @Autowired
    RestTemplateService restTemplateService;

    @PostMapping(value = "sendMessage")
    public ResultMap sendMessage(@RequestBody Message message){
        messageSend.send();
        return new ResultMap().successResult(restTemplateService.userHello(message));
    }

}
