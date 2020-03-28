package com.graduate.club.service.impl;

import com.graduate.club.dao.AdminDao;
import com.graduate.club.entity.Admin;
import com.graduate.club.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminServiceImpl extends BaseServiceImpl<Admin, AdminDao> implements AdminService {

    @Autowired
    private AdminDao adminDao;

}
