package com.xlj.springcloud.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author XLJ
 * @date 2020/10/9
 */
public interface AccountService {
    void decrease(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money);
}
