package com.graduate.club.dao;

import com.graduate.club.entity.Activity;

import java.util.List;
import java.util.Map;

public interface ActivityDao extends BaseDao<Activity> {
    //查询该社团全年活动数
    int sumActivity(String clubId);

    List<Map<String,Object>> selectActivity(Map<String,Object> activity);
}
