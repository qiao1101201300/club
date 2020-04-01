package com.graduate.club.mapper;

import com.graduate.club.entity.News;

import java.util.List;
import java.util.Map;

public interface NewsMapper extends BaseMapper<News> {

    List<Map<String,Object>> selectNews(Map<String, Object> map);
}