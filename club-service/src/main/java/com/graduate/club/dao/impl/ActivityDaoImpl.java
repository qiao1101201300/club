package com.graduate.club.dao.impl;

import com.graduate.club.dao.ActivityDao;
import com.graduate.club.entity.Activity;
import com.graduate.club.mapper.ActivityMapper;
import com.graduate.club.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ActivityDaoImpl extends BaseDaoImpl<Activity, ActivityMapper> implements ActivityDao {

    @Autowired
    private ActivityMapper activityMapper;


    @Override
    public int sumActivity(String clubId) {
        return activityMapper.sumActivity(clubId);
    }

    @Override
    public List<Map<String,Object>> selectActivity(Map<String,Object> activity) {
        return activityMapper.selectActivity(activity);
    }
}
