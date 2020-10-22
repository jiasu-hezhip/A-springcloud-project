package com.sll.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.sll.springcloud.dao"})
public class MyBatisConfig {
}
