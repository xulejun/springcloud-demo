package com.xlj.springcloud.service;

import com.xlj.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author XLJ
 * @date 2020/10/9
 */
public interface StorageService {
    // 扣减库存
    void decrease(Long productId, Integer count);
}
