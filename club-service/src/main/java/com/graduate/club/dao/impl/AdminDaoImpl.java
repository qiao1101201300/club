package com.graduate.club.dao.impl;

import com.graduate.club.dao.AdminDao;
import com.graduate.club.entity.Admin;
import com.graduate.club.mapper.AdminMapper;
import com.graduate.club.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class AdminDaoImpl extends BaseDaoImpl<Admin, AdminMapper> implements AdminDao {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin getUserByUserName(String username) {
        return adminMapper.getUserByUserName(username, Constants.UserStatus.NORMAL);
    }
}
