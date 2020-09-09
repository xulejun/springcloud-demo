package com.xlj.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author XLJ
 * @date 2020/9/8
 */
@Configuration
public class RibbonRule {
    /**
     * @description: 随机
     * @author XLJ
     * @date 2020/9/8 10:18
    */
    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}
