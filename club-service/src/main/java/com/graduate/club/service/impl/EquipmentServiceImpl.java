package com.graduate.club.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduate.club.dao.EquipmentDao;
import com.graduate.club.entity.Equipment;
import com.graduate.club.service.EquipmentService;
import com.graduate.club.util.StringUtils;
import com.graduate.club.vo.EquipmentVO;
import com.graduate.club.vo.PageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EquipmentServiceImpl extends BaseServiceImpl<Equipment, EquipmentDao> implements EquipmentService {

    @Resource
    private EquipmentDao equipmentDao;

    @Override
    public PageVO selectByMap(EquipmentVO equipmentVO) {
        Map<String, Object> map = new HashMap();
        if (StringUtils.isNotBlank(equipmentVO.getName())){
            map.put("name",equipmentVO.getName());
        }
        if (equipmentVO.getNum() != null){
            map.put("num",equipmentVO.getNum());
        }
        PageHelper.startPage(equipmentVO.getPageNum(), equipmentVO.getPageSize() == 0 ? 10 : equipmentVO.getPageSize());
        List<Map<String, Object>> list = equipmentDao.selectByMap(map);
        PageInfo<Map<String, Object>> pageInfoList = new PageInfo<>(list);
        PageVO page = new PageVO();
        BeanUtils.copyProperties(equipmentVO, page);
        page.setQuery(list);
        page.setTotal((int) pageInfoList.getTotal());
        return page;
    }
}
