package com.graduate.club.dao.impl;

import com.graduate.club.dao.UserActivityDao;
import com.graduate.club.entity.UserActivity;
import com.graduate.club.mapper.UserActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class UserActivityDaoImpl extends BaseDaoImpl<UserActivity, UserActivityMapper> implements UserActivityDao {

    @Autowired
    private UserActivityMapper userActivityMapper;

}
