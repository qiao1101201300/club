package com.graduate.society.mapper;

import com.graduate.society.entity.User;

public interface UserMapper extends BaseMapper<User> {

    User getUserByUserName(String username);
}