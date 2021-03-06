package com.goods;

import com.annotation.EnableAmqp;
import com.annotation.EnableRedis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: lvchao
 * @Date: 2018-11-09 14:35
 * @Email:641819417@qq.com
 */
//这里还可以直接启动 @SpringCloudApplication 里面包含了熔断和 @SpringBootApplication  @EnableDiscoveryClient 配置
@SpringBootApplication
@EnableEurekaClient   //配置了这个 就不用配置 @EnableDiscoveryClient
@EnableCircuitBreaker  //熔断器配置
@EnableAmqp
@EnableRedis
public class GoodsServiceApplication {

    public static void main(String[] args){
        SpringApplication.run(GoodsServiceApplication.class,args);
    }

    /**
     * 配置 ribbon 的负载均衡 默认是轮询的方式
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
