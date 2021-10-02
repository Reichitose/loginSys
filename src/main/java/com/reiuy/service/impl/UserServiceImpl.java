package com.reiuy.service.impl;

import com.reiuy.dao.UserDao;
import com.reiuy.entity.User;
import com.reiuy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;



@Service
public class UserServiceImpl implements UserService {


    @Resource
    private UserDao userDao;


    @Override
    public int registerUser(User user) {
        int nums = userDao.addUser(user);
        return nums;
    }

    @Override
    public User logincheck(User user) {
        return userDao.selectUser(user);
    }

    @Override
    public int updateusertime(User user) {
        int nums = userDao.updateUser(user);
        return nums;
    }

    @Override
    public User namecheck(User user) {

        return userDao.selectsamename(user);
    }
}
