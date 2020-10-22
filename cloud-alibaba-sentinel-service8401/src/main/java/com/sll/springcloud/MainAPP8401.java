package com.sll.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MainAPP8401{
    public static void main(String[] args) {
        SpringApplication.run(MainAPP8401.class, args);
    }
}
