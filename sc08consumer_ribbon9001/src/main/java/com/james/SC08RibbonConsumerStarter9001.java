package com.james;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
//@RibbonClients({@RibbonClient("sc02privider"), @RibbonClient("sc02privider")})
//@RibbonClient("sc02privider")
@RibbonClient(value = "sc02privider", configuration = RibbonConfig.class)
public class SC08RibbonConsumerStarter9001 {

    public static void main(String[] args) {
        SpringApplication.run(SC08RibbonConsumerStarter9001.class, args);
    }

    @Bean
    @LoadBalanced   //  给当前对象开启负载均衡，调用@RibbonClient("sc02privider")这个配置的服务时开启均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
