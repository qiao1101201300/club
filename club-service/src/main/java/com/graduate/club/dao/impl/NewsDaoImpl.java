package com.graduate.club.dao.impl;

import com.graduate.club.dao.NewsDao;
import com.graduate.club.entity.News;
import com.graduate.club.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NewsDaoImpl extends BaseDaoImpl<News, NewsMapper> implements NewsDao {
    @Autowired
    private NewsMapper newsMapper;

}
