package com.graduate.club.service.impl;

import com.graduate.club.dao.ActivityDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.graduate.club.entity.Activity;
import com.graduate.club.mapper.ActivityMapper;
import com.graduate.club.service.ActivityService;

@Service
@Slf4j
public class ActivityServiceImpl extends BaseServiceImpl<Activity, ActivityDao> implements ActivityService {

    @Autowired
    private ActivityDao activityDao;
}
