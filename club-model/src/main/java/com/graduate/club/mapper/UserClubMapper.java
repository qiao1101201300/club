package com.graduate.club.mapper;

import com.graduate.club.entity.UserClub;
import com.graduate.club.entity.UserProfile;
import com.graduate.club.vo.ResultVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserClubMapper extends BaseMapper<UserClub> {

    @Select("")
    ResultVO selectClubUser(UserProfile userProfile);
}