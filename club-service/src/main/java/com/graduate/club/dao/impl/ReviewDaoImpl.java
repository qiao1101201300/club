package com.graduate.club.dao.impl;

import com.graduate.club.dao.ReviewDao;
import com.graduate.club.entity.Review;
import com.graduate.club.mapper.ReviewMapper;
import com.graduate.club.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ReviewDaoImpl extends BaseDaoImpl<Review, ReviewMapper> implements ReviewDao {

    @Autowired
    private ReviewMapper reviewMapper;

    @Override
    public List<Map<String,Object>> selectByMap(Map<String, Object> map) {
        return reviewMapper.selectByMap(map);
    }
}
