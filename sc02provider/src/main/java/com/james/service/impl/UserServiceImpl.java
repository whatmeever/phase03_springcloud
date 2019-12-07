package com.james.service.impl;

import com.james.dao.IUserDao;
import com.james.pojo.Users;
import com.james.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public List<Users> getAllUsers() {
        return userDao.getALlUsers();
    }

    @Override
    public boolean saveUser(Users u) {
        return userDao.saveUsers(u) > 0;
    }

    @Override
    public boolean updateUser(Users u) {
        return userDao.updateUsers(u) > 0;
    }

    @Override
    public Users getUserByUid(int uid) {
        return userDao.getUserByUid(uid);
    }
}
