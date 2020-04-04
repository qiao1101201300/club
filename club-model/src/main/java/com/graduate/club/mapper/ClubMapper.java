package com.graduate.club.mapper;

import com.graduate.club.entity.Club;
import com.graduate.club.vo.PageVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ClubMapper extends BaseMapper<Club> {
    /**
     * 查询社团成员数
     *
     * @param clubid
     * @return
     */
    @Select("SELECT * FROM t_user_club WHERE clubid ='#{clubid}' AND `status`=#{status};")
    PageVO selectClubUserByClubid(String clubid, int status);

    List<Map<String, Object>> selectByMap(Map<String, Object> map);
}