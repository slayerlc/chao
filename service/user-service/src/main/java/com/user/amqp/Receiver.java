package com.user.amqp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: lvchao
 * @Date: 2018-08-02 11:37
 */
@Component
@Slf4j
public class Receiver {

    //这里参数取决于 发送的时候 的参数类型 对应就可以
    @RabbitHandler
    @RabbitListener(queues = "serviceUser")
    public void process(String obj){
        log.info("receiver content:{}",obj);
        System.out.println("teset"+obj);
    }
}
