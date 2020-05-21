package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author jacksonlee
 * @create 2020-05-19 16:22
 */

@Service
public class PaymentService {


    public String paymentInfoOK(Integer id){
        return "ThreadPool:" + Thread.currentThread().getName() + ": paymentInfoOk, id:" + id;
    }


    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value="true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value="10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value="10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value="60"),
    })
    public String paymentCircuitBreaker (@PathVariable("id") Integer id) {
        if (id < 0){
            throw new RuntimeException("***** id can not be negative");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用成功, 流水号:" + serialNumber ;
    }

    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id){
        return "id不能为负数，id:" + id;
    }


    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandle", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value="3000")
    })
    public String paymentInfoTimeOut(Integer id) {
        int timeNumber = 6;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ThreadPool: " + Thread.currentThread().getName() +
                "paymentInfoTimeOut, id:" + id + "\t" + "takes " + timeNumber + "s";
    }

    public String paymentInfoTimeOutHandle(Integer id){
        return "ThreadPool: " + Thread.currentThread().getName() +
                "paymentInfoTimeOutHandle, id:" + id + "\t" + "System is overloaded";
    }
}
