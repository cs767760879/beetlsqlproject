package com.lianxun.service;

import com.lianxun.entity.User;

import java.util.List;

/**
 * @ClassName Userservice
 * @Description
 * @Author Vera
 * @Date 2020/2/21 15:56
 * @Version 1.0
 **/
public interface Userservice {
    List<User> selectAll();

    List<User> selectUserPage(int start, int offset);

    void insertUser(User user);

    void updataUser(User user);
}
