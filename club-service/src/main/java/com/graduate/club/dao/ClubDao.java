package com.graduate.club.dao;

import com.graduate.club.entity.Club;
import com.graduate.club.vo.ResultVO;

import java.util.List;

public interface ClubDao extends BaseDao<Club> {
    //查询全部社团
    List<Club> selectAllClubByUserId(String userId);
    //查询用户所加入的社团数
    Club selectClubByUserId(String userId);
    //根据社团id查询社团人数
    ResultVO selectClubUserByClubid(String cludid,int status);

}
