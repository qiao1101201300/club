package com.graduate.club.service.impl;

import com.graduate.club.dao.UserActivityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.graduate.club.entity.UserActivity;
import com.graduate.club.mapper.UserActivityMapper;
import com.graduate.club.service.UserActivityService;

@Service
public class UserActivityServiceImpl extends BaseServiceImpl<UserActivity,UserActivityDao> implements UserActivityService {

    @Autowired
    private UserActivityDao userActivityDao;


}
