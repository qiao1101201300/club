package com.demo.club.service.impl;

import com.demo.club.entity.RoleMenu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.demo.club.mapper.RoleMenuMapper;
import com.demo.club.service.RoleMenuService;

@Service
public class RoleMenuServiceImpl extends BaseServiceImpl<RoleMenu, RoleMenuMapper> implements RoleMenuService {

    @Resource
    private RoleMenuMapper roleMenuMapper;

}
