package com.xlj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Hystrix图形化界面
 * @author XLJ
 * @date 2020/9/14
 */
@SpringBootApplication
@EnableHystrixDashboard

public class HystrixDashboard9001 {
    // 监控地址：http://localhost:9001/hystrix
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard9001.class,args);
    }
}
