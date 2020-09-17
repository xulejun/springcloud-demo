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
public class StreamMqConsumerMain8802 {
    public static void main(String[] args) {
        SpringApplication.run(StreamMqConsumerMain8802.class,args);
    }
}
