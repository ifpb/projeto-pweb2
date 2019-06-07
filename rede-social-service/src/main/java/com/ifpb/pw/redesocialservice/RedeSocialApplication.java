package com.ifpb.pw.redesocialservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RedeSocialApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedeSocialApplication.class, args);
    }
}
