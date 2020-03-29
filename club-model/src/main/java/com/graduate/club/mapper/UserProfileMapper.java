package com.graduate.club.mapper;

import com.graduate.club.entity.UserProfile;

public interface UserProfileMapper extends BaseMapper<UserProfile> {

    UserProfile selectByUserId(String userId);
}