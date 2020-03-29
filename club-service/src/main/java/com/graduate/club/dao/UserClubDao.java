package com.graduate.club.dao;

import com.graduate.club.entity.User;
import com.graduate.club.entity.UserClub;

public interface UserClubDao extends BaseDao<UserClub> {
    UserClub selectMyClub(User user);

}
