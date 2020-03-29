package com.graduate.club.dao.impl;

import com.graduate.club.dao.UserProfileDao;
import com.graduate.club.entity.UserProfile;
import com.graduate.club.mapper.UserMapper;
import com.graduate.club.mapper.UserProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserProfileDaoImpl extends BaseDaoImpl<UserProfile, UserProfileMapper> implements UserProfileDao {

    @Autowired
    UserProfileMapper userProfileMapper;
    @Override
    public UserProfile selectByUserId(String userId) {
        return userProfileMapper.selectByUserId(userId);
    }
}
