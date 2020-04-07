package com.graduate.club.mapper;

import com.graduate.club.entity.Equipment;

import java.util.List;
import java.util.Map;

public interface EquipmentMapper extends BaseMapper<Equipment> {

    List<Map<String, Object>> selectByMap(Map<String, Object> map);
}