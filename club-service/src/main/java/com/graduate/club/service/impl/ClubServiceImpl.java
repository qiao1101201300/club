package com.graduate.club.service.impl;

import com.graduate.club.dao.ClubDao;
import com.graduate.club.dao.impl.BaseDaoImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.graduate.club.entity.Club;
import com.graduate.club.mapper.ClubMapper;
import com.graduate.club.service.ClubService;

@Service
@Slf4j
public class ClubServiceImpl extends BaseServiceImpl<Club, ClubDao> implements ClubService {

    @Autowired
    private ClubDao clubDao;

}
