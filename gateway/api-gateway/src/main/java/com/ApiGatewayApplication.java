package com;

import com.filter.PreGatewayFilterFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayApplication {


    public static void main(String args[]) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    /**
     * spring cloud gateway 路由配置 这里是最简单的配置方式
     * 具体还有很多种配置 可以在官网查询到
     *
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                /*.route(predicateSpec -> predicateSpec.path("/hello/**").filters(gatewayFilterSpec -> gatewayFilterSpec
                               .filter(new ApiGatewayFilterFactory().apply(new ApiGatewayFilterFactory.Config()))
                               .filter(new PreGatewayFilterFactory().apply(new PreGatewayFilterFactory.Config()))
                               .addResponseHeader("X-OTHERHEADER", "TEST")
                ).uri("http://www.163.com")).build();*/
        //目前这里的问题不知道为什么,下面配置的这个路由是无效的 对于服务调用 gateway只能使用他自己默认定义的路由规则对应到服务,自定义的都无效。
                .route(predicateSpec -> predicateSpec.path("/test/**").filters(gatewayFilterSpec -> gatewayFilterSpec
                               .filter(new PreGatewayFilterFactory().apply(new PreGatewayFilterFactory.Config()))
                ).uri("lb://USER-SERVICE-V1")).build();
        // http://localhost:9999/USER-SERVICE-V1/user/hello  所以这里的服务路由/USER-SERVICE-V1/** 其实是gateway默认自己根据服务名称定义的
    }

    /**
     * 启动 WebClient 负载均衡  spring cloud gateway 使用的是webFlux
     * webClient是webFlux 里面用来调用别的服务的类似ribbon的restTemplate
     *
     * @return
     */
    @Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }

    /*@Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }*/
}
