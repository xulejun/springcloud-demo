package com.xlj.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.xlj.springcloud.service.PaymentHystrixService;
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
public class PaymentHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/comsumer/payment/hystrix/success/{id}")
    public String getSuccess(@PathVariable("id") Integer id){
        return paymentHystrixService.getSuccess(id);
    }

    @GetMapping(value = "/comsumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "getTimeoutHandle", commandProperties =
            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")})
    public String getTimeout(@PathVariable("id") Integer id){
        return paymentHystrixService.getTimeout(id);
    }

    public String getTimeoutHandle(Integer id) {
        return "当前服务为客户端80，线程池：" + Thread.currentThread().getName() + "被调用 , 80的getTimeout方法超时";
    }
}
