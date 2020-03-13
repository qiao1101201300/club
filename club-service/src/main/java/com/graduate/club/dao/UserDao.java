package com.graduate.club.dao;

import com.graduate.club.entity.User;

public interface UserDao extends BaseDao<User> {

    User getUserByUserName(String username);
}
