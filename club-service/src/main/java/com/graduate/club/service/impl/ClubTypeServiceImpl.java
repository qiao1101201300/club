package com.graduate.club.service.impl;

import com.graduate.club.dao.ClubTypeDao;
import com.graduate.club.entity.ClubType;
import com.graduate.club.service.ClubTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class ClubTypeServiceImpl extends BaseServiceImpl<ClubType, ClubTypeDao> implements ClubTypeService {

    @Autowired
    private ClubTypeDao clubTypeDao;

}
