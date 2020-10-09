package com.xlj.springcloud.controller;

import com.xlj.springcloud.domain.CommonResult;
import com.xlj.springcloud.domain.Order;
import com.xlj.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author XLJ
 * @date 2020/10/9
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    public CommonResult create(Order order){
        orderService.create(order);
        return new CommonResult(200,"创建订单成功");
    }
}
