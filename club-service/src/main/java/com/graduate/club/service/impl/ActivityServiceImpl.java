package com.graduate.club.service.impl;

import com.graduate.club.dao.ActivityDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduate.club.entity.Activity;
import com.graduate.club.service.ActivityService;

@Service
@Slf4j
public class ActivityServiceImpl extends BaseServiceImpl<Activity, ActivityDao> implements ActivityService {

    @Autowired
    private ActivityDao activityDao;

    @Override
    public int sumActivity(String clubId) {

        return activityDao.sumActivity(clubId);
    }
}
