package com.james.controller;

import com.james.pojo.Users;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/userconsumerhystrix")
public class UserController {
    @Autowired
    private RestTemplate template;

    @Autowired
    private EurekaClient eurekaClient; //这个对象spring会自动创建不需要我们额外创建

    @GetMapping("/all/{uid}")
    //execution.isolation.strategy 上下文的传播策略 有多线程和同线程两个机制,多线程并不是说我们当前的方法和失败方法在不同的线程,而是指处理这两个方法的线程和创建网络请求的线程是不是一样的
    //@HystrixCommand(fallbackMethod = "abc",commandProperties = {@HystrixProperty(name = "execution.isolation.strategy",value = "THREAD")}) //给当前方法设置失败后的操作,失败后到底做什么fallbackMethod指定一个方法名,当出现问题的时候会去执行这个方法,要求这个方法的参数和返回值必须和当前方法一致
    public Users getUserById(@PathVariable int uid) throws Exception {
        System.out.println("出错的线程" + Thread.currentThread().getName());
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("04PROVIDER-EUREKA", false);//cong euerka上获取指定名字的服务的信息
        String url = instanceInfo.getHomePageUrl();//获取服务的地址 也就是 类似于 http://localhost:8000
        System.out.println("服务提供者的地址:======>"+url);
        Users user = template.getForObject(url+"/user/info/" + uid, Users.class);//请求指定地址并将返回的json字符串转换为User对象
        return user;
    }
    @PostMapping("/save")
    public String addUser(@RequestBody Users user) {
        String result = template.postForObject("http://localhost:8000/user/save/", user, String.class);//post方式请求这个地址,并将user作为参数传递过去(json格式),并将返回结果转换为String类型
        return result;
    }

    @GetMapping("/all")
    public List<Users> getAllUsers(){
        return template.getForObject("http://localhost:8000/user/all", List.class);
    }

    public Users abc(Long id){
        System.out.println("降级的线程" + Thread.currentThread().getName());
        Users user = new Users();
        user.setUid(-100);
        user.setUsername("刚才失败传递的id是:==>" + id);
        return user;
    }
}
