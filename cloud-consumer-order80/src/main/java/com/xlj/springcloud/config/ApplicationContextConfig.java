package com.xlj.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate 配置注入
 * @Author XLJ
 * @Date 2020/9/1
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced   // 集群版RestTemplate负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
