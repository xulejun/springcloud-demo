package com.xlj.springcloud.controller;

import com.xlj.springcloud.entities.CommonResult;
import com.xlj.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author XLJ
 * @Date 2020/9/1
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://localhost:8001";
    @Resource
    private RestTemplate restTemplate;

    /**
     * @description: 使用RestTempla实现远程调用
     * @author XLJ
     * @date 2020/9/1 10:25
     */
    @GetMapping(value = "/comsumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        log.info("消费者调用创建payment");
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }
    @GetMapping(value = "/comsumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        log.info("消费者调用查询payment");
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }
}
