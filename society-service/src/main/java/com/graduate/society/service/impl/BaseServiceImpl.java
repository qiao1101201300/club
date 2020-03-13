package com.graduate.society.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduate.society.dao.BaseDao;
import com.graduate.society.entity.BaseEntity;
import com.graduate.society.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class BaseServiceImpl<T extends BaseEntity, I extends BaseDao<T>> implements BaseService<T> {
    @Autowired
    public I baseDao;

    @Override
    public boolean insertSelective(T info) {
        if (info == null) {
            return false;
        }

        return baseDao.insertSelective(info) > 0;
    }

    @Override
    public boolean insert(T info) {
        if (info == null) {
            return false;
        }
        return baseDao.insert(info) > 0;
    }

    @Override
    public boolean deleteByPrimaryKey(String id) {
        if (id == null) {
            return false;
        }
        return baseDao.deleteByPrimaryKey(id) > 0;
    }


    @Override
    public boolean updateByPrimaryKey(T info) {
        if (info == null) {
            return false;
        }
        return baseDao.updateByPrimaryKey(info) > 0;
    }

    @Override
    public boolean updateByPrimaryKeySelective(T info) {
        if (info == null) {
            return false;
        }
        return baseDao.updateByPrimaryKeySelective(info) > 0;
    }

    @Override
    public PageInfo<T> selectList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<T> list=baseDao.selectAll();
        PageInfo<T> pageInfoList = new PageInfo<>(list);
        return pageInfoList;
    }

    @Override
    public T selectByPrimaryKey(String id) {
        if (id == null) {
            return null;
        }
        return baseDao.selectByPrimaryKey(id);
    }

    @Override
    public List<T> selectAll() {
        return baseDao.selectAll();
    }
}