package com.graduate.club.service;

import com.graduate.club.entity.User;
import com.graduate.club.entity.UserClub;
import com.graduate.club.vo.ResultVO;

public interface UserClubService extends BaseService<UserClub>{
    ResultVO selectMyClub(String userId);
}
