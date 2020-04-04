package com.graduate.club.dao;

import com.graduate.club.entity.Review;
import com.graduate.club.vo.PageVO;

import java.util.List;
import java.util.Map;

public interface ReviewDao extends BaseDao<Review> {


    List<Map<String,Object>> selectByMap(Map<String, Object> map);
}
