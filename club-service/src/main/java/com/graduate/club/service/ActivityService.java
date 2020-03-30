package com.graduate.club.service;

import com.graduate.club.entity.Activity;

public interface ActivityService extends BaseService<Activity> {

    int sumActivity(String clubId);
}
