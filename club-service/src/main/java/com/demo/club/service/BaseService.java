package com.demo.club.service;

import com.demo.club.entity.BaseEntity;

import java.util.List;

public interface BaseService<T extends BaseEntity> {
    boolean insert(T t);

    boolean insertSelective(T t);

    T selectByPrimaryKey(String id);

    List<T> select(T t);

    T selectOne(T t);

    List<T> selectAll();

    boolean updateByPrimaryKey(T t);

    boolean updateByPrimaryKeySelective(T t);

}
