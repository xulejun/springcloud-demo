package com.xlj.springcloud.controller;

import com.xlj.springcloud.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author XLJ
 * @date 2020/9/17
 */
@RestController
public class MessageController {
    @Resource
    private MessageService messageService;

    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        System.out.println("uuid："+messageService.sendMessage());
        return null;
    }
}
