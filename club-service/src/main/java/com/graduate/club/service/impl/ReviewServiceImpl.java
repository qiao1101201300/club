package com.graduate.club.service.impl;

import com.graduate.club.dao.ReviewDao;
import com.graduate.club.entity.Review;
import com.graduate.club.mapper.ReviewMapper;
import com.graduate.club.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl extends BaseServiceImpl<Review, ReviewDao> implements ReviewService {

    @Autowired
    private ReviewDao reviewDao;

}
