package com.graduate.club.dao;

import com.graduate.club.entity.Recruit;
import com.graduate.club.service.BaseService;

import java.util.List;
import java.util.Map;

public interface RecruitDao extends BaseDao<Recruit>{

    List<Map<String, Object>> selectByMap(Map<String, Object> map);
}
