package com.graduate.club.dao.impl;

import com.graduate.club.dao.RecruitDao;
import com.graduate.club.entity.Recruit;
import com.graduate.club.mapper.RecruitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class RecruitDaoImpl extends BaseDaoImpl<Recruit, RecruitMapper> implements RecruitDao {

    @Autowired
    private RecruitMapper recruitMapper;

}
