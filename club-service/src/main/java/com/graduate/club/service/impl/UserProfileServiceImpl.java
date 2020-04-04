package com.graduate.club.service.impl;

import com.graduate.club.dao.UserProfileDao;
import com.graduate.club.entity.UserProfile;
import com.graduate.club.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserProfileServiceImpl extends BaseServiceImpl<UserProfile, UserProfileDao> implements UserProfileService {

    @Autowired
    private UserProfileDao userProfileDao;

    @Override
    public UserProfile selectByUserId(String userId) {
        return userProfileDao.selectByUserId(userId);
    }

    @Override
    public boolean updateByUserId(UserProfile userProfile) {
        return userProfileDao.updateByUserId(userProfile);
    }
}

