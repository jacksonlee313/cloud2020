package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.SpringCacheAnnotationParser;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author jacksonlee
 * @create 2020-05-19 12:21
 */

@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain80 {

    public static void main(String[] args) {

        SpringApplication.run(OrderFeignMain80.class, args);
    }

}
