package com.graduate.club.dao.impl;

import com.graduate.club.dao.UserClubDao;
import com.graduate.club.entity.User;
import com.graduate.club.entity.UserClub;
import com.graduate.club.entity.UserProfile;
import com.graduate.club.mapper.UserClubMapper;
import com.graduate.club.mapper.UserMapper;
import com.graduate.club.service.UserClubService;
import com.graduate.club.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Repository
public class UserClubDaoImpl extends BaseDaoImpl<UserClub,UserClubMapper> implements UserClubDao {

    @Autowired
   private UserClubMapper userClubMapper;

    @Override
    public UserClub selectMyClub(User user) {
        return userClubMapper.selectByPrimaryKey(user.getId());
    }

    @Override
    public ResultVO selectClubUser(UserProfile userProfile) {
        return userClubMapper.selectClubUser(userProfile);
    }


}
