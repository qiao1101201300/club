package com.graduate.club.dao;

import com.graduate.club.entity.News;
import com.graduate.club.vo.NewsVO;

import java.util.List;
import java.util.Map;

public interface NewsDao extends BaseDao<News> {


    List<Map<String,Object>> selectNews(Map<String,Object> map);
}
