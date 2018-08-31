package com.message.service.impl;

import com.message.model.Message;
import com.message.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Message testService(Message message){
        return message;
    }
}
