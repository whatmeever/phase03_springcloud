package com.james;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SC03EurekaServerStarter10000 {

    public static void main(String[] args) {
        SpringApplication.run(SC03EurekaServerStarter10000.class, args);
    }
}
