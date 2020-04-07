package com.graduate.club.dao.impl;

import com.graduate.club.dao.ClubLeaseDao;
import com.graduate.club.entity.ClubLease;
import com.graduate.club.mapper.ClubLeaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ClubLeaseDaoImpl extends BaseDaoImpl<ClubLease, ClubLeaseMapper> implements ClubLeaseDao {

    @Autowired
    private ClubLeaseMapper clubLeaseMapper;

    @Override
    public List<Map<String, Object>> selectByMap(Map<String, Object> map) {
        return clubLeaseMapper.selectByMap(map);
    }
}
