package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author jacksonlee
 * @create 2020-05-19 20:25
 */

@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfoOk(Integer id) {
        return "paymentInfo is OK";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "-------paymentService fallback---------";
    }
}
