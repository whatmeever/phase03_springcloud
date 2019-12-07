package com.james.feign;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.james.pojo.Users;

import java.util.List;

@org.springframework.cloud.openfeign.FeignClient("sc02privider")
public interface FeignClient {

    @GetMapping("/user/all")
    List<Users> getAllUsers();

    @GetMapping("/user/all/{uid}")
    Users getUserById(@PathVariable("uid") int uid);//注意在controller里面PathVariable的路径参数和方法的形参名字一样的时候可以忽略里面的名字.但是在feign里面必须写

    @PostMapping("/user/save")//这个方法上面只要有参数 就会被发出去,如果传递的是复杂对象,不管这里是不是GET都会以post方式发出去,出错还是不出错,取决于提供者那边的限定
    String save(Users user);
}
