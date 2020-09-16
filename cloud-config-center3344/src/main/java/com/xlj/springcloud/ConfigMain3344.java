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
        // http://config3344:3344/master/config-test.yml 访问远程git配置文件
        SpringApplication.run(ConfigMain3344.class, args);
    }
}
