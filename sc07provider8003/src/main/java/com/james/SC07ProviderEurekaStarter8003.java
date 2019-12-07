package com.james;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SC07ProviderEurekaStarter8003 {

    public static void main(String[] args) {
        SpringApplication.run(SC07ProviderEurekaStarter8003.class);
    }
}
