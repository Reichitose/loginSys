package com.reiuy.dao;

import com.reiuy.entity.User;

public interface UserDao {

    int addUser(User user);
    //用户的添加
    User selectUser(User user);
    //查询用户
    int updateUser(User user);
    //更新用户上次登录时间,及次数

    User selectsamename(User user);
    //用于检查是否存在重名

}
