package com.xlj.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author XLJ
 * @date 2020/9/11
 */
@Component
@FeignClient("CLOUD-PAYMENT-HYSTRIX-SERVICE")
public interface PaymentHystrixService {

    @GetMapping(value = "/payment/hystrix/success/{id}")
    String getSuccess(@PathVariable("id") Integer id);

    @GetMapping(value = "/payment/hystrix/timeout/{id}")
    String getTimeout(@PathVariable("id") Integer id);

}
