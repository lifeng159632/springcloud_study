package com.lee.demospringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class DemoSpringCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringCloudApplication.class, args);
    }
}
