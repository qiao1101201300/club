package com.graduate.club.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduate.club.dao.NewsDao;
import com.graduate.club.entity.News;
import com.graduate.club.service.NewsService;
import com.graduate.club.util.StringUtils;
import com.graduate.club.vo.NewsVO;
import com.graduate.club.vo.PageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsServiceImpl extends BaseServiceImpl<News, NewsDao> implements NewsService {

    @Autowired
    private NewsDao newsDao;

    @Override
    public PageVO selectNews(NewsVO newsVO) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isNotBlank(newsVO.getName())) {
            map.put("name", newsVO.getName());
        }
        if (newsVO.getStatus() != null) {
            map.put("status", newsVO.getStatus());
        }
        PageHelper.startPage(newsVO.getPageNum(), newsVO.getPageSize() == 0 ? 10 : newsVO.getPageSize());
        List<Map<String, Object>> mapList = newsDao.selectNews(map);
        PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(mapList);
        PageVO page = new PageVO();
        BeanUtils.copyProperties(newsVO, page);
        page.setQuery(mapList);
        page.setTotal((int) pageInfo.getTotal());
        return page;
    }
}
