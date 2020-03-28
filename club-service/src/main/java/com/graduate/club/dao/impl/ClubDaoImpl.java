package com.graduate.club.dao.impl;

import com.graduate.club.dao.ClubDao;
import com.graduate.club.entity.Club;
import com.graduate.club.mapper.ClubMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ClubDaoImpl extends BaseDaoImpl<Club,ClubMapper> implements ClubDao {

    @Autowired
    private ClubMapper clubMapper;

}
