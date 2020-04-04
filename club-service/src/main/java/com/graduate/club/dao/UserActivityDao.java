package com.graduate.club.dao;

import com.graduate.club.entity.UserActivity;

import java.util.List;
import java.util.Map;

public interface UserActivityDao extends BaseDao<UserActivity> {


    List<Map<String, Object>> selectByMap(Map<String, Object> map);
}
