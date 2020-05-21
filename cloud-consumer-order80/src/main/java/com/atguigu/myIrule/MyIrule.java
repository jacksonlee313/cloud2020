package com.atguigu.myIrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jacksonlee
 * @create 2020-05-18 16:12
 */

@Configuration
public class MyIrule {

    @Bean
    public IRule iRule() {
        return new RandomRule();
    }
}
