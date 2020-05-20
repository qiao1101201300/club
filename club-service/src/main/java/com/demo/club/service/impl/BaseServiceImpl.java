package com.demo.club.service.impl;

import com.demo.club.entity.BaseEntity;
import com.demo.club.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Slf4j
public class BaseServiceImpl<T extends BaseEntity, I extends BaseMapper<T>> implements BaseService<T> {

    @Autowired
    private I mapper;

    @Override
    public boolean insert(T t) {
        return mapper.insert(t) > 0;
    }

    @Override
    public boolean insertSelective(T t) {
        return mapper.insertSelective(t) > 0;
    }

    @Override
    public T selectByPrimaryKey(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> select(T t) {
        return mapper.select(t);
    }

    @Override
    public T selectOne(T t) {
        return mapper.selectOne(t);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public boolean updateByPrimaryKey(T t) {
        return mapper.updateByPrimaryKey(t) > 0;
    }

    @Override
    public boolean updateByPrimaryKeySelective(T t) {
        return mapper.updateByPrimaryKeySelective(t) > 0;
    }
}