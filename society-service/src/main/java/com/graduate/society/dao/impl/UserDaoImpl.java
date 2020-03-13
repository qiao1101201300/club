package com.graduate.society.dao.impl;

import com.graduate.society.dao.UserDao;
import com.graduate.society.entity.User;
import com.graduate.society.mapper.UserMapper;
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
