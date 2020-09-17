package com.xlj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author XLJ
 * @date 2020/9/17
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMqConsumerMain8803 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMqConsumerMain8803.class,args);
    }
}
