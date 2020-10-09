package com.xlj.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author XLJ
 * @date 2020/10/9
 */
@Configuration
@MapperScan({"com.xlj.springcloud.dao"})
public class MybatisConfig {
}
