package com.graduate.club.mapper;

import com.graduate.club.entity.ClubLease;

import java.util.List;
import java.util.Map;

public interface ClubLeaseMapper extends BaseMapper<ClubLease> {

    List<Map<String, Object>> selectByMap(Map<String, Object> map);
}