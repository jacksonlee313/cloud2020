package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

/**
 * @author jacksonlee
 * @create 2020-05-19 17:31
 */

@RestController
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class PaymentHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfoOk(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
   /* @HystrixCommand(fallbackMethod = "paymentTimeoutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })*/
    @HystrixCommand
    public String paymentInfoTimeOut(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfoTimeOut(id);
    }

    public String paymentTimeoutFallbackMethod(@PathVariable("id") Integer id) {
        return "Payment System is busy, Please try again later";
    }

    public String paymentGlobalFallbackMethod() {
        return "This is a global fallback method";
    }
}
