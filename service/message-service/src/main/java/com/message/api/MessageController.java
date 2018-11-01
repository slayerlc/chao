package com.message.api;

import com.message.amqp.MessageSend;
import com.message.model.Message;
import com.message.service.MessageService;
import com.message.service.RestTemplateService;
import com.general.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

    /*@Autowired
    RedisTemplate<String,Object> redisTemplate;*/

    @PostMapping(value = "sendMessage")
    public ResultMap sendMessage(@RequestBody Message message){
        //messageSend.send("所有服务听好了，今天全部给我加班。");
        message = messageService.testService(message);
        //return new ResultMap().successResult(restTemplateService.userHello(message));
        return new ResultMap(message);
    }

}
