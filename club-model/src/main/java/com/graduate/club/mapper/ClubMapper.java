package com.graduate.club.mapper;

import com.graduate.club.entity.Club;
import com.graduate.club.vo.ResultVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ClubMapper extends BaseMapper<Club>{

    /**
     * 查询社团成员数
     * @param clubid
     * @return
     */
    @Select("SELECT * FROM t_user_club WHERE clubid ='#{clubid}' AND `status`=#{status};")
    ResultVO selectClubUserByClubid(String clubid,int status);
}