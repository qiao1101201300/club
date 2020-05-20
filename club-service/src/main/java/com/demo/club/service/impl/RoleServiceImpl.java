package com.demo.club.service.impl;

import com.demo.club.mapper.RoleMapper;
import com.demo.club.entity.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.demo.club.service.RoleService;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleMapper> implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public Role selectAllMenu(String id) {
        return roleMapper.selectAllMenu(id);
    }
}
