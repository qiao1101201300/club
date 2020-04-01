package com.graduate.club.dao;

import com.graduate.club.entity.UserProfile;

public interface UserProfileDao extends BaseDao<UserProfile>{

    UserProfile selectByUserId(String userid);

}

