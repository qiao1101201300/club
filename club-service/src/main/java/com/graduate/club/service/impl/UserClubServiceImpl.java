package com.graduate.club.service.impl;

import com.graduate.club.dao.UserClubDao;
import com.graduate.club.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.graduate.club.entity.UserClub;
import com.graduate.club.mapper.UserClubMapper;
import com.graduate.club.service.UserClubService;

@Service
public class UserClubServiceImpl extends BaseServiceImpl<UserClub, UserClubDao> implements UserClubService {

    @Autowired
    private UserClubMapper userClubMapper;

}
