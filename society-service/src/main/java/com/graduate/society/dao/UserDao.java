package com.graduate.society.dao;

import com.graduate.society.entity.User;

public interface UserDao extends BaseDao<User> {

    User getUserByUserName(String username);
}
