package com.graduate.club.mapper;

import com.graduate.club.entity.Recruit;

import java.util.List;
import java.util.Map;

public interface RecruitMapper extends BaseMapper<Recruit> {

    List<Map<String, Object>> selectByMap(Map<String, Object> map);

    Recruit selectByClubId(String clubid);
}