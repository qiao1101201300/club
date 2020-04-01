package com.graduate.club.service.impl;

import com.graduate.club.dao.UserProfileDao;
import com.graduate.club.entity.UserProfile;
import com.graduate.club.service.UserProfileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserProfileServiceImpl extends BaseServiceImpl<UserProfile, UserProfileDao> implements UserProfileService {

    @Resource
    private UserProfileDao userProfileDaoImpl;

    @Override
    public UserProfile selectByUserId(String userId) {
        return userProfileDaoImpl.selectByUserId(userId);
    }
}

