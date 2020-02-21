package com.lianxun.service.impl;

import com.lianxun.dao.UserDao;
import com.lianxun.entity.User;
import com.lianxun.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author Vera
 * @Date 2020/2/21 15:56
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements Userservice {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public List<User> selectUserPage(int start, int offset) {
        return userDao.selectUserPage(start, offset);
    }

    @Override
    public void insertUser(User user) {
        userDao.insert(user);
    }

    @Override
    public void updataUser(User user) {
        userDao.updateById(user);
    }
}
