package com.graduate.club.service.impl;

import com.graduate.club.dao.NewsDao;
import com.graduate.club.entity.News;
import com.graduate.club.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl extends BaseServiceImpl<News, NewsDao> implements NewsService {

    @Autowired
    private NewsDao newsDao;

}
