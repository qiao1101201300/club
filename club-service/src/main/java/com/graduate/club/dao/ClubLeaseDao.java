package com.graduate.club.dao;

import com.graduate.club.entity.ClubLease;

import java.util.List;
import java.util.Map;

public interface ClubLeaseDao extends BaseDao<ClubLease> {

    List<Map<String, Object>> selectByMap(Map<String, Object> map);
}
