package com.xlj.springcloud.service;

import com.xlj.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author XLJ
 * @date 2020/10/9
 */
@FeignClient(value = "seata-account-service")
public interface AccountSerivce {
    @PostMapping(value = "/account/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
