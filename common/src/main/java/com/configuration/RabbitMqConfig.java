package com.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: lvchao
 * @Date: 2018-08-02 11:40
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue helloQueue(){
        return new Queue("helloKey");
    }
}
