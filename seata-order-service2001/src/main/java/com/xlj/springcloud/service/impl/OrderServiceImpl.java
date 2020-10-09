package com.xlj.springcloud.service.impl;

import com.xlj.springcloud.dao.OrderDao;
import com.xlj.springcloud.domain.Order;
import com.xlj.springcloud.service.AccountSerivce;
import com.xlj.springcloud.service.OrderService;
import com.xlj.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author XLJ
 * @date 2020/10/9
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private AccountSerivce accountSerivce;
    @Resource
    private StorageService storageService;

    @Override
    public void create(Order order) {
        log.info("开始创建订单");
        orderDao.create(order);

        log.info("订单微服务开始调用库存，进行扣减");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("库存扣减结束");

        log.info("订单微服务开始调用账户，进行扣减");
        accountSerivce.decrease(order.getProductId(),order.getCount());
        log.info("账户扣减结束");
    }
}
