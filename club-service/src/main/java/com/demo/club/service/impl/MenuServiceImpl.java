package com.demo.club.service.impl;

import com.demo.club.entity.Menu;
import com.demo.club.mapper.MenuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.demo.club.service.MenuService;

@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu, MenuMapper> implements MenuService {

    @Resource
    private MenuMapper menuMapper;

}
