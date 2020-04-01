package com.graduate.club.dao;

import com.graduate.club.entity.User;
import com.graduate.club.entity.UserClub;
import com.graduate.club.entity.UserProfile;
import com.graduate.club.vo.ResultVO;

public interface UserClubDao extends BaseDao<UserClub> {
    UserClub selectMyClub(User user);
    //模糊查询用户
    ResultVO selectClubUser(UserProfile userProfile);
}
