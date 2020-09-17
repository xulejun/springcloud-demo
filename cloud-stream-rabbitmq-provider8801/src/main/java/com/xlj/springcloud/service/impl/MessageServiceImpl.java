package com.xlj.springcloud.service.impl;

import com.xlj.springcloud.service.MessageService;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author XLJ
 * @date 2020/9/17
 */
@EnableBinding(Source.class)        // 定义消息的推送
public class MessageServiceImpl implements MessageService {

    @Resource
    private MessageChannel output;

    @Override
    public String sendMessage() {
        String uuid = UUID.randomUUID().toString();
        // 通过消息构建，构建出发送的消息，再利用消息管道进行传输
        output.send(MessageBuilder.withPayload(uuid).build());
        return uuid;
    }
}
