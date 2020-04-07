package com.graduate.club.dao.impl;

import com.graduate.club.dao.RecruitDao;
import com.graduate.club.entity.Recruit;
import com.graduate.club.mapper.RecruitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository
public class RecruitDaoImpl extends BaseDaoImpl<Recruit, RecruitMapper> implements RecruitDao {

    @Autowired
    private RecruitMapper recruitMapper;

    @Override
    public List<Map<String, Object>> selectByMap(Map<String, Object> map) {
        return recruitMapper.selectByMap(map);
    }

    @Override
    public Recruit selectByClubId(String clubid) {
        return recruitMapper.selectByClubId(clubid);
    }
}
