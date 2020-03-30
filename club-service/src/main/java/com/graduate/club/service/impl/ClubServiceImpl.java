package com.graduate.club.service.impl;

import com.graduate.club.dao.ClubDao;
import com.graduate.club.mapper.ClubMapper;
import com.graduate.club.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduate.club.entity.Club;
import com.graduate.club.service.ClubService;

import java.util.List;

@Service
@Slf4j
public class ClubServiceImpl extends BaseServiceImpl<Club, ClubDao> implements ClubService {

    @Autowired
    private ClubDao clubDao;


    @Override
    public List<Club> selectAllClubByUserId(String userId) {
        return clubDao.selectAllClubByUserId(userId);
    }

    @Override
    public Club selectClubByUserId(String userId) {
        return (Club) clubDao.selectClubByUserId(userId);
    }

    @Override
    public ResultVO selectClubUserByClubid(String clubid,int status) {
        return clubDao.selectClubUserByClubid(clubid,status);
    }
}
