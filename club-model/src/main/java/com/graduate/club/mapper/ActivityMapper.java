package com.graduate.club.mapper;

import com.graduate.club.entity.Activity;
import com.graduate.club.vo.ResultVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ActivityMapper extends BaseMapper<Activity> {
    /**
     * 根据社团id查询社团全年活动数
     * @return
     */
    @Select("select count(#{clubId}) from t_activity where clubid=#{clubid}")
    int sumActivity(String clubId);
}