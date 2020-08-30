package com.xlj.springcloud.service.impl;

import com.xlj.springcloud.entities.Payment;
import com.xlj.springcloud.mapper.PaymentMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author XuLeJun
 * @Date 2020/8/29 11:00
 */
@Service
public class PaymentServiceImpl {
    @Autowired
    private PaymentMapper paymentMapper;

    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }

}
