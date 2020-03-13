package com.graduate.society.service.impl;

import com.graduate.society.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduate.society.entity.User;
import com.graduate.society.service.UserService;

import java.util.Set;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserDao> implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public User getUserByUserName(String username) {
        return userDao.getUserByUserName(username);
    }

    @Override
    public Set<String> findUserPermissionsByUserName(String username) {
        return null;
    }

    @Override
    public Set<String> findUserRolesByUserName(String username) {
        return null;
    }
}
