package springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author XLJ
 * @date 2020/9/17
 */
@Component
@EnableBinding(Sink.class)
public class MessageController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)     // 监听队列，用于消费者的队列的消息接收
    public void getMessage(Message<String> message) {
        System.out.println("消费者serverPort：" + serverPort + "\t\t" + "uuid：" + message.getPayload());
    }
}
