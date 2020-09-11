package com.xlj.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xlj.springcloud.service.PaymentHystrixService;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author XLJ
 * @date 2020/9/11
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalFallbackHandle")    // Hystrix全局降级处理
public class PaymentHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/comsumer/payment/hystrix/success/{id}")
    public String getSuccess(@PathVariable("id") Integer id) {
        return paymentHystrixService.getSuccess(id);
    }

    @GetMapping(value = "/comsumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "getTimeoutHandle", commandProperties =
//            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")}) //私有服务降级配置
    @HystrixCommand     // 全局服务降级
    public String getTimeout(@PathVariable("id") Integer id) {
        return paymentHystrixService.getTimeout(id);
    }

    /**
     * @description: 私有的服务降级处理方法
     * @author XLJ
     * @date 2020/9/11 16:21
     */
    public String getTimeoutHandle(Integer id) {
        return "当前服务为客户端80，线程池：" + Thread.currentThread().getName() + "被调用 , 80的getTimeout方法超时";
    }

    /**
     * @description: 全局降级处理方法
     * @author XLJ
     * @date 2020/9/11 16:23
     */
    public String globalFallbackHandle() {
        return "当前为Hystrix全局降级处理方法，部分服务调用有误";
    }
}
