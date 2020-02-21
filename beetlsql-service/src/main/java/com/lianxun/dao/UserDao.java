package com.lianxun.dao;

import com.lianxun.entity.*;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;

import java.util.List;

@SqlResource("tUser")
public interface UserDao extends BaseMapper<User> {
    List<User> selectAll();

    List<User> selectUserPage(@Param("start") int start, @Param("offset") int offset);
}