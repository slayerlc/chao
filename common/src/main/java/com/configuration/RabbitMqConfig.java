package com.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: lvchao
 * @Date: 2018-08-02 11:40
 */
@Configuration
@Component
public class RabbitMqConfig {

    @Bean
    public Queue serviceMessage(){
        return new Queue("serviceMessage");
    }

    @Bean
    public Queue serviceUser(){
        return new Queue("serviceUser");
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("serviceFanoutExchange");
    }

    @Bean
    public Binding bindingServiceMessage(Queue serviceMessage, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(serviceMessage).to(fanoutExchange);
    }

    @Bean
    public Binding bindingServiceUser(Queue serviceUser, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(serviceUser).to(fanoutExchange);
    }
}
