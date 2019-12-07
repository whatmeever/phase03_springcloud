package com.james.service;

import com.james.pojo.Users;

import java.util.List;

public interface IUserService {

    List<Users> getAllUsers();

    boolean saveUser(Users u);

    boolean updateUser(Users u);

    Users getUserByUid(int uid);
}
