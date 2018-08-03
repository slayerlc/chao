package com.annotation;

import com.configuration.RabbitMqConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author: lvchao
 * @Date: 2018-08-03 13:55
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Configuration
@Import({RabbitMqConfig.class})
public @interface EnableAmqp {
}
