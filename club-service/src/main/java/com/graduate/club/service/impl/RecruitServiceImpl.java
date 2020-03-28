package com.graduate.club.service.impl;

import com.graduate.club.dao.RecruitDao;
import com.graduate.club.entity.Recruit;
import com.graduate.club.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RecruitServiceImpl extends BaseServiceImpl<Recruit, RecruitDao> implements RecruitService {

    @Autowired
    private RecruitDao recruitDao;

}
