package com.gateway;

import com.gateway.filter.ApiGatewayFilterFactory;
import com.gateway.filter.PreGatewayFilterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
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
                ).uri("http://www.163.com"))*/

                .route(predicateSpec -> predicateSpec.path("/USER-SERVICE/**").filters(gatewayFilterSpec -> gatewayFilterSpec
                               .filter(new PreGatewayFilterFactory().apply(new PreGatewayFilterFactory.Config()))

                ).uri("lb://USER-SERVICE")).build();
    }

    /**
     * 启动 WebClient 负载均衡
     * webClient是webFlux 里面用来调用别的服务的类似ribbon的restTemplate
     *
     * @return
     */
    /*@Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }*/

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
