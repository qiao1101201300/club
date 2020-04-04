package com.graduate.club.service;

import com.graduate.club.entity.UserActivity;
import com.graduate.club.vo.PageVO;
import com.graduate.club.vo.UserActivityVO;

public interface UserActivityService extends BaseService<UserActivity>{

    PageVO selectByMap(UserActivityVO userActivityVO);
}
