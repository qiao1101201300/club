package com.graduate.club.service;

import com.graduate.club.entity.User;
import com.graduate.club.entity.UserClub;
import com.graduate.club.vo.ResultVO;

public interface UserClubService extends BaseService<UserClub>{
    //根据用户id查询加入的社团
    ResultVO selectMyClub(String userId);


}
