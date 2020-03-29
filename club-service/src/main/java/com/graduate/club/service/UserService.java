package com.graduate.club.service;

import com.graduate.club.entity.User;
import com.graduate.club.vo.ResultVO;

import java.util.Map;
import java.util.Set;

public interface UserService extends BaseService<User> {

    User getUserByUserName(String username);

    ResultVO login(User user);
}
