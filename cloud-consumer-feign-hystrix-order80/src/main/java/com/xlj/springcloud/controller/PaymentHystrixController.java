package com.xlj.springcloud.controller;

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
    public String getTimeout(@PathVariable("id") Integer id){
        return paymentHystrixService.getTimeout(id);
    }
}
