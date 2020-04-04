package com.graduate.club.mapper;

import com.graduate.club.entity.Review;

import java.util.List;
import java.util.Map;

public interface ReviewMapper extends BaseMapper<Review> {

    List<Map<String, Object>> selectByMap(Map<String, Object> map);
}