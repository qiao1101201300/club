package com.graduate.club.service;

import com.graduate.club.entity.UserProfile;

public interface UserProfileService extends BaseService<UserProfile> {

    UserProfile selectByUserId(String id);
}

