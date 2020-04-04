package com.graduate.club.dao.impl;

import com.graduate.club.dao.UserProfileDao;
import com.graduate.club.entity.UserProfile;
import com.graduate.club.mapper.UserProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserProfileDaoImpl extends BaseDaoImpl<UserProfile, UserProfileMapper> implements UserProfileDao {

    @Autowired
    private UserProfileMapper userProfileMapper;
    @Override
    public UserProfile selectByUserId(String userid) {
        return userProfileMapper.selectByUserId(userid);
    }

    @Override
    public boolean updateByUserId(UserProfile userProfile) {
        return userProfileMapper.updateByUserId(userProfile);
    }


}
