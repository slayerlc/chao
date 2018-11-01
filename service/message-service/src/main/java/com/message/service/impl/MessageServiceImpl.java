package com.message.service.impl;

import com.distributedlock.RedisLock;
import com.message.model.Message;
import com.message.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author: lvchao
 * @Date: 2018-07-30 15:44
 */
@Service
@Slf4j
public class MessageServiceImpl implements MessageService{

    /*@Autowired
    MessageRepository messageRepository;*/

    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RedisLock redisLock;

    public int i = 0;

    public Message testService(Message message){
        //这里的lock key 可以是一条数据的ID  这样的话加锁 不会锁住整个服务 而是对每一条数据上锁
        if(!redisLock.addLock("lvchao")){
            System.out.println("当前数据被锁定");
            return null;
        }
        System.out.println(++i);
        try {
            Thread.sleep(100000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        redisLock.unLock("lvchao");
        return message;
    }
}
