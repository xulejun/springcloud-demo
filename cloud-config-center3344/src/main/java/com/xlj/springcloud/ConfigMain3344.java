package com.xlj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author XLJ
 * @date 2020/9/15
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigMain3344 {
    public static void main(String[] args) {
        // http://config3344:3344/master/config-dev.yml    访问远程git配置文件
        // http://localhost:3344/actuator/bus-refresh   Bus通知所有服务（要用POST请求，浏览器默认为GET）
        // http://localhost:3344/actuator/bus-refresh/cloud-config-server:3355 只通知3355客户端（要用POST请求，浏览器默认为GET）
        SpringApplication.run(ConfigMain3344.class, args);
    }
}
