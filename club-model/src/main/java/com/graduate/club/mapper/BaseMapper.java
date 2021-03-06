package com.graduate.club.mapper;

import com.graduate.club.entity.BaseEntity;

import java.util.List;

public interface BaseMapper<T extends BaseEntity> {
    int deleteByPrimaryKey(String id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(String id);

    List<T> selectAll();

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}