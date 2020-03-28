package com.graduate.club.dao.impl;

import com.graduate.club.dao.UserProfileDao;
import com.graduate.club.entity.UserProfile;
import com.graduate.club.mapper.UserProfileMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserProfileDaoImpl extends BaseDaoImpl<UserProfile, UserProfileMapper> implements UserProfileDao {

}
