package com.xlj.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XLJ
 * @date 2020/9/18
 */
@RestController
@RefreshScope     // 支持Nacos的动态刷新
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value = "/nacos/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }

}
