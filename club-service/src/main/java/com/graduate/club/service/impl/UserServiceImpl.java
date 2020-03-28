package com.graduate.club.service.impl;

import com.graduate.club.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduate.club.entity.User;
import com.graduate.club.service.UserService;

import java.util.Set;

@Service
@Slf4j
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
