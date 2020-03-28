package com.graduate.club.dao.impl;

import com.graduate.club.dao.ReviewDao;
import com.graduate.club.entity.Review;
import com.graduate.club.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReviewDaoImpl extends BaseDaoImpl<Review, ReviewMapper> implements ReviewDao {

    @Autowired
    private ReviewMapper reviewMapper;

}
