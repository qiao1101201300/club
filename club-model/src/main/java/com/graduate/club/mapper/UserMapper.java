package com.graduate.club.mapper;

import com.graduate.club.entity.User;

public interface UserMapper extends BaseMapper<User> {

    User getUserByUserName(String username);
}