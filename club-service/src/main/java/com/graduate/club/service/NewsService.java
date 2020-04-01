package com.graduate.club.service;

import com.graduate.club.entity.News;
import com.graduate.club.vo.NewsVO;
import com.graduate.club.vo.PageVO;

public interface NewsService extends BaseService<News> {


    PageVO selectNews(NewsVO newsVO);
}
