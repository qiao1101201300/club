package com.demo.club.service.impl;

import com.demo.club.entity.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.demo.club.mapper.AdminMapper;
import com.demo.club.service.AdminService;

@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin, AdminMapper> implements AdminService {

    @Resource
    private AdminMapper adminMapper;

}
