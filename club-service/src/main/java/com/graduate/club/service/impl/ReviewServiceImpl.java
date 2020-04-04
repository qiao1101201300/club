package com.graduate.club.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduate.club.dao.ReviewDao;
import com.graduate.club.entity.Review;
import com.graduate.club.mapper.ReviewMapper;
import com.graduate.club.service.ReviewService;
import com.graduate.club.util.StringUtils;
import com.graduate.club.vo.PageVO;
import com.graduate.club.vo.ReviewVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReviewServiceImpl extends BaseServiceImpl<Review, ReviewDao> implements ReviewService {

    @Autowired
    private ReviewDao reviewDao;

    @Override
    public PageVO selectByMap(ReviewVO reviewVO) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isNotBlank(reviewVO.getClubName())) {
            map.put("clubName",reviewVO.getClubName());
        }
        if (reviewVO.getStar() != null){
            map.put("star",reviewVO.getStar());
        }
        if (reviewVO.getAdminName() != null){
            map.put("adminName",reviewVO.getAdminName());
        }
        PageHelper.startPage(reviewVO.getPageNum(), reviewVO.getPageSize() == 0 ? 10 : reviewVO.getPageSize());
        List<Map<String, Object>> mapList = reviewDao.selectByMap(map);
        PageInfo<Map<String, Object>> pageInfoList = new PageInfo<>(mapList);
        PageVO page = new PageVO();
        BeanUtils.copyProperties(reviewVO, page);
        page.setQuery(mapList);
        page.setTotal((int) pageInfoList.getTotal());
        return page;
    }
}
