package com.graduate.club.service;

import com.graduate.club.entity.Activity;
import com.graduate.club.vo.ActivityVO;
import com.graduate.club.vo.PageVO;

public interface ActivityService extends BaseService<Activity> {

    int sumActivity(String clubId);

    PageVO selectActivity(ActivityVO activityVO);

    boolean create(Activity activity);
}
