package com.sll.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder builder= routeLocatorBuilder.routes();
        builder.route("path_sll_test",r->r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return builder.build();
    }

}
