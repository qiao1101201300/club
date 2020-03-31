package com.graduate.club.mapper;

import com.graduate.club.entity.Activity;import org.apache.ibatis.annotations.Select;import java.util.List;import java.util.Map;

public interface ActivityMapper extends BaseMapper<Activity>{

    /**
     * 根据社团id查询社团全年活动数
     *
     * @return
     */
    @Select("select count(#{clubId}) from t_activity where clubid=#{clubid}")
    int sumActivity(String clubId);

    List<Map<String,Object>> selectActivity(Map<String,Object> map);
}