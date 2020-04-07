package com.graduate.club.dao.impl;

import com.graduate.club.dao.EquipmentDao;
import com.graduate.club.entity.Equipment;
import com.graduate.club.mapper.EquipmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class EquipmentDaoImpl extends BaseDaoImpl<Equipment,EquipmentMapper> implements EquipmentDao {

    @Autowired
    private EquipmentMapper equipmentMapper;

    @Override
    public List<Map<String, Object>> selectByMap(Map<String, Object> map) {
        return equipmentMapper.selectByMap(map);
    }
}
