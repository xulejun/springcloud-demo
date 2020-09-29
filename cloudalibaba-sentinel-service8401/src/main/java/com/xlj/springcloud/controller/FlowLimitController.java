package com.xlj.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XLJ
 * @date 2020/9/29
 */
@RestController
public class FlowLimitController {
    @GetMapping(value = "/testA")
    public String testA(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "testA";

    }

    @GetMapping(value = "/testB")
    public String testB(){
        return "testB";

    }
}
