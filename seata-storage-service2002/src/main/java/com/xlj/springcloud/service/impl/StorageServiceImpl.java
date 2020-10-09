package com.xlj.springcloud.service.impl;

import com.xlj.springcloud.dao.StorageDao;
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
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("库存微服务扣减库存开始");
        storageDao.decrease(productId,count);
        log.info("库存微服务扣减库存结束");
    }
}
