package com.graduate.club.dao;

import com.graduate.club.entity.Equipment;

import java.util.List;
import java.util.Map;

public interface EquipmentDao extends BaseDao<Equipment> {

    List<Map<String, Object>> selectByMap(Map<String, Object> map);
}
