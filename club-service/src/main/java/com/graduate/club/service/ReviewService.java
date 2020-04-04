package com.graduate.club.service;

import com.graduate.club.entity.Review;
import com.graduate.club.vo.PageVO;
import com.graduate.club.vo.ReviewVO;

public interface ReviewService extends BaseService<Review> {

    PageVO selectByMap(ReviewVO reviewVO);
}
