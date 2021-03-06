package com.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class ApiGatewayFilterFactory extends AbstractGatewayFilterFactory<ApiGatewayFilterFactory.Config>{

    public ApiGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {

        return (exchange, chain) -> chain.filter(exchange);
    }

    public static class Config{

    }
}
