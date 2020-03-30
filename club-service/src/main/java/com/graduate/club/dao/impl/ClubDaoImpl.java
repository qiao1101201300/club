package com.graduate.club.dao.impl;

import com.graduate.club.dao.ClubDao;
import com.graduate.club.entity.Club;
import com.graduate.club.mapper.ClubMapper;
import com.graduate.club.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ClubDaoImpl extends BaseDaoImpl<Club,ClubMapper> implements ClubDao {

    @Autowired
    private ClubMapper clubMapper;

    @Override
    public List<Club> selectAllClubByUserId(String userId) {
        return (List<Club>) clubMapper.selectByPrimaryKey(userId);
    }

    @Override
    public Club selectClubByUserId(String userId) {
        return clubMapper.selectByPrimaryKey(userId);
    }

    @Override
    public ResultVO selectClubUserByClubid(String clubid,int status) {
        return clubMapper.selectClubUserByClubid(clubid,status);
    }


}
