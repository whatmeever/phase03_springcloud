package com.james.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.james.feign.FeignClient;
import com.james.pojo.Users;

import java.util.List;

@RestController
@RequestMapping("/userfeign")
public class UserController {
	
    @Autowired //此处不需要我们手动创建这个对象,spring会自动帮我们创建,因为这个接口上面有注解
    private FeignClient feignClient01;

    @GetMapping("/all")
    public List<Users> getAllUsers(){
        return feignClient01.getAllUsers();
    }

    @GetMapping("/all/{id}")
    public Users getUserById(@PathVariable int id) throws Exception {
        return feignClient01.getUserById(id);
    }
    @PostMapping("/save")
    public String addUser(@RequestBody Users user) {
        String result = feignClient01.save(user);
        return result;
    }

}