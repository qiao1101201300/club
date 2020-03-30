package com.graduate.club.service;

import com.graduate.club.entity.Club;
import com.graduate.club.vo.ResultVO;

import java.util.List;

public interface ClubService extends BaseService<Club> {

    List<Club> selectAllClubByUserId(String userId);

    Club selectClubByUserId(String userId);

    //根据社团id查询社团人数
    ResultVO selectClubUserByClubid(String clubid,int status);
}
