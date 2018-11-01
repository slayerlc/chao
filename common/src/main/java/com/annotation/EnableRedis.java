package com.annotation;

import com.configuration.RedisConfig;
import com.distributedlock.RedisLock;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author: lvchao
 * @Date: 2018-10-31 13:54
 * @Email:641819417@qq.com
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Configuration
@Import({RedisConfig.class, RedisLock.class})
public @interface EnableRedis {
}
