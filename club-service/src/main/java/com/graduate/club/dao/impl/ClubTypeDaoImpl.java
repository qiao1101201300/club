package com.graduate.club.dao.impl;

import com.graduate.club.dao.ClubTypeDao;
import com.graduate.club.entity.ClubType;
import com.graduate.club.mapper.ClubTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class ClubTypeDaoImpl extends BaseDaoImpl<ClubType,ClubTypeMapper> implements ClubTypeDao {

    @Autowired
    private ClubTypeMapper clubTypeMapper;

}
