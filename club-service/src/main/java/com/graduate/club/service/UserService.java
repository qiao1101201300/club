package com.graduate.club.service;

import com.graduate.club.entity.User;

import java.util.Set;

public interface UserService extends BaseService<User> {

    User getUserByUserName(String username);

    Set<String> findUserPermissionsByUserName(String username);

    Set<String> findUserRolesByUserName(String username);
}
