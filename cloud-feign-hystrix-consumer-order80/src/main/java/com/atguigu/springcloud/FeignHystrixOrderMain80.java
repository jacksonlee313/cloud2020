package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.NamedInheritableThreadLocal;

import javax.activation.MailcapCommandMap;

/**
 * @author jacksonlee
 * @create 2020-05-19 17:26
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class FeignHystrixOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignHystrixOrderMain80.class, args);
    }
}
