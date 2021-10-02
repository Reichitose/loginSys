package com.reiuy.service;

import com.reiuy.entity.User;

public interface UserService {

    int registerUser(User user);
    //注册,参数为User,返回值是查询结果
    User logincheck(User user);
    //登录的查询,查询结果是user的所有数据
    int updateusertime(User user);
    //更新数据

    User namecheck(User user);
    //防止重名
}
