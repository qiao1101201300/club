package com.graduate.club.dao.impl;

import com.graduate.club.dao.BaseDao;
import com.graduate.club.entity.BaseEntity;
import com.graduate.club.mapper.BaseMapper;
import com.graduate.club.util.DateUtils;
import com.graduate.club.util.StringUtils;
import com.graduate.club.util.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class BaseDaoImpl<T extends BaseEntity, I extends BaseMapper<T>> implements BaseDao<T> {

    @Autowired
    private I mapper;

    private Date nowTime = DateUtils.toDatetime(new Date());

    @Override
    public int deleteByPrimaryKey(String id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(T record) {
        if (StringUtils.isBlank(record.getId())){
            record.setId(UUIDUtils.getUUID());
        }
        record.setCreateAt(nowTime);
        record.setUpdateAt(nowTime);
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(T record) {
        if (StringUtils.isBlank(record.getId())){
            record.setId(UUIDUtils.getUUID());
        }
        record.setCreateAt(nowTime);
        record.setUpdateAt(nowTime);
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
        record.setUpdateAt(nowTime);
        return mapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(T record) {
        record.setUpdateAt(nowTime);
        return mapper.updateByPrimaryKey(record);
    }

}
