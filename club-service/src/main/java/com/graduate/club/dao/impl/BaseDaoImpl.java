package com.graduate.club.dao.impl;

import com.graduate.club.dao.BaseDao;
import com.graduate.club.entity.BaseEntity;
import com.graduate.club.mapper.BaseMapper;
import com.graduate.club.util.DateUtils;
import com.graduate.club.util.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Slf4j
public class BaseDaoImpl<T extends BaseEntity, I extends BaseMapper<T>> implements BaseDao<T> {

    @Autowired
    private I mapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T record) {
        record.setId(UUIDUtils.getUUID());
        record.setCreateAt(DateUtils.toDatetime(new Date()));
        record.setUpdateAt(DateUtils.toDatetime(new Date()));
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(T record) {
        record.setId(UUIDUtils.getUUID());
        record.setCreateAt(DateUtils.toDatetime(new Date()));
        record.setUpdateAt(DateUtils.toDatetime(new Date()));
        return mapper.insertSelective(record);
    }

    @Override
    public T selectByPrimaryKey(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int updateByPrimaryKeySelective(T record) {
        record.setUpdateAt(DateUtils.toDatetime(new Date()));
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        record.setUpdateAt(DateUtils.toDatetime(new Date()));
        return mapper.updateByPrimaryKey(record);
    }

}
