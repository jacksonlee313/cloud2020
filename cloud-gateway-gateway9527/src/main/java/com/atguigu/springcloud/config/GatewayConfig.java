package com.atguigu.springcloud.config;

import com.atguigu.springcloud.GatewayMain9527;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.netty.http.server.HttpServerRoutes;

import java.math.RoundingMode;

/**
 * @author jacksonlee
 * @create 2020-05-20 16:08
 */

/*
@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator routeLocator(){
        RouteLocatorBuilder.Builder builder =
                new RouteLocatorBuilder.Builder(new AnnotationConfigApplicationContext(GatewayMain9527.class));
        builder.route("path_route_atguigu", r -> r.path("/guonei").uri("http://www.baidu.com/guonei"));
        return builder.build();
    }

}
*/
