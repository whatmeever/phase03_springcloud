package com.james;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients//开启对feign的支持
public class SC09ConsumerFeignStarter9007 {

	public static void main(String[] args) {
		SpringApplication.run(SC09ConsumerFeignStarter9007.class, args);
	}

}
