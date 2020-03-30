package com.graduate.club.dao;

import com.graduate.club.entity.Activity;
import com.graduate.club.vo.ResultVO;

public interface ActivityDao extends BaseDao<Activity> {
    //查询该社团全年活动数
    int sumActivity(String clubId);
}
