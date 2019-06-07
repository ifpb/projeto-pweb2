package com.ifpb.pw.redesocialservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RedeSocialApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedeSocialApplication.class, args);
    }
}
