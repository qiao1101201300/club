package com.graduate.club.service;

import com.graduate.club.entity.Equipment;
import com.graduate.club.vo.EquipmentVO;
import com.graduate.club.vo.PageVO;

public interface EquipmentService extends BaseService<Equipment> {

    PageVO selectByMap(EquipmentVO equipmentVO);
}
