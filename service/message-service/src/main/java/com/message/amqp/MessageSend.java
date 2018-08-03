package com.message.amqp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: lvchao
 * @Date: 2018-08-02 11:31
 */
@Component
@Slf4j
public class MessageSend {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String str = "hello";
        log.info("send start Object:{}",str);
        this.amqpTemplate.convertAndSend("helloKey",str);
    }
}
