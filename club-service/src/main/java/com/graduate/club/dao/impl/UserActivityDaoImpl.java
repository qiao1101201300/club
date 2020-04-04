package com.graduate.club.dao.impl;

import com.graduate.club.dao.UserActivityDao;
import com.graduate.club.entity.UserActivity;
import com.graduate.club.mapper.UserActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Repository
public class UserActivityDaoImpl extends BaseDaoImpl<UserActivity, UserActivityMapper> implements UserActivityDao {

    @Autowired
    private UserActivityMapper userActivityMapper;

    @Override
    public List<Map<String, Object>> selectByMap(Map<String, Object> map) {
        return userActivityMapper.selectByMap(map);
    }
}
