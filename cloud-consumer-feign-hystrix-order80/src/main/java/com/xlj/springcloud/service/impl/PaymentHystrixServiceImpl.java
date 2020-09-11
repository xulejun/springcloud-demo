package com.xlj.springcloud.service.impl;

import com.xlj.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Service;

/**
 * @author XLJ
 * @date 2020/9/11
 */

@Service
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String getSuccess(Integer id) {
        return "Order调用服务消费者全局异常处理";
    }

    @Override
    public String getTimeout(Integer id) {
        return "Order调用服务消费者全局异常处理";
    }
}
