package com.graduate.club.dao.impl;

import com.graduate.club.dao.UserDao;
import com.graduate.club.entity.User;
import com.graduate.club.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User, UserMapper> implements UserDao {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByUserName(String username) {
        return userMapper.getUserByUserName(username);
    }
}
