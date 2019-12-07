package com.james.controller;

import com.james.pojo.Users;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/userconsumerribbon")
public class UserController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancerClient client;

    @GetMapping("/all")
    public List<Users> getAllUsers(){
        return restTemplate.getForObject("http://sc02privider/user/all/", List.class);
    }

    @GetMapping("/all/{uid}")
    public Users getUserByUid(@PathVariable int uid){
        return restTemplate.getForObject("http://sc02privider/user/all/" + uid, Users.class);
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody Users u){
        return restTemplate.postForObject("http://sc02privider/user/save", u, String.class);
    }

    @GetMapping("/test")
    public String hello(){
        int port = client.choose("04privider-eureka").getPort();
        return "world" + port;
    }
}
