package com.james.controller;

import com.james.pojo.Users;
import com.james.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("/all")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/all/{uid}")
    public Users getUserByUid(@PathVariable int uid){
        return userService.getUserByUid(uid);
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody Users u){
        boolean flag = userService.saveUser(u);

        String result= (flag ? "success" : "fail");
        return result;
    }
}
