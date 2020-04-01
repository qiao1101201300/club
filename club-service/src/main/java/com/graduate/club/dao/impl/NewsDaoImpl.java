package com.graduate.club.dao.impl;

import com.graduate.club.dao.NewsDao;
import com.graduate.club.entity.News;
import com.graduate.club.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class NewsDaoImpl extends BaseDaoImpl<News, NewsMapper> implements NewsDao {
    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<Map<String,Object>> selectNews(Map<String, Object> map) {
        return newsMapper.selectNews(map);
    }
}
