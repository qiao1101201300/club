package com.graduate.club.mapper;

import com.graduate.club.entity.UserActivity;

import java.util.List;
import java.util.Map;

public interface UserActivityMapper extends BaseMapper<UserActivity> {
    List<Map<String, Object>> selectByMap(Map<String, Object> map);
}