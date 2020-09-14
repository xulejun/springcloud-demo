package com.xlj.springcloud.controller;

import com.xlj.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/hystrix/success/{id}")
    public String getSuccess(@PathVariable("id") Integer id){
        return paymentService.getSuccess(id);
    }

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    public String getTimeout(@PathVariable("id") Integer id){
        return paymentService.getTimeout(id);
    }

    @GetMapping(value = "/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        return paymentService.paymentCircuitBreaker(id);
    }

}
