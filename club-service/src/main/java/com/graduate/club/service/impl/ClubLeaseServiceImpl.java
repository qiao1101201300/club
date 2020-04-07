package com.graduate.club.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduate.club.dao.ClubLeaseDao;
import com.graduate.club.entity.ClubLease;
import com.graduate.club.entity.Equipment;
import com.graduate.club.service.ClubLeaseService;
import com.graduate.club.service.EquipmentService;
import com.graduate.club.util.Constants;
import com.graduate.club.util.StringUtils;
import com.graduate.club.vo.ClubLeaseVO;
import com.graduate.club.vo.PageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClubLeaseServiceImpl extends BaseServiceImpl<ClubLease, ClubLeaseDao> implements ClubLeaseService {

    @Autowired
    private ClubLeaseDao clubLeaseDao;
    @Autowired
    private EquipmentService equipmentService;

    @Override
    @Transactional
    public boolean create(ClubLease clubLease) {
        Equipment equipment = equipmentService.selectByPrimaryKey(clubLease.getEquipmentid());
        equipment.setNum(equipment.getNum() - clubLease.getNum());
        equipmentService.updateByPrimaryKeySelective(equipment);
        return clubLeaseDao.insertSelective(clubLease) > 0;
    }

    @Override
    @Transactional
    public boolean update(ClubLease clubLease) {
        ClubLease clubLease1 = clubLeaseDao.selectByPrimaryKey(clubLease.getClubid());
        Equipment equipment = equipmentService.selectByPrimaryKey(clubLease.getEquipmentid());
        equipment.setNum(equipment.getNum() + clubLease1.getNum() - clubLease.getNum());
        equipmentService.updateByPrimaryKeySelective(equipment);
        return clubLeaseDao.updateByPrimaryKey(clubLease) > 0;
    }

    @Override
    public PageVO selectByMap(ClubLeaseVO clubLeaseVO) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isNotBlank(clubLeaseVO.getClubName())) {
            map.put("clubName", clubLeaseVO.getClubName());
        }
        if (StringUtils.isNotBlank(clubLeaseVO.getClubLeaseName())) {
            map.put("clubLeaseName", clubLeaseVO.getClubLeaseName());
        }
        PageHelper.startPage(clubLeaseVO.getPageNum(), clubLeaseVO.getPageSize() == 0 ? 10 : clubLeaseVO.getPageSize());
        List<Map<String, Object>> list = clubLeaseDao.selectByMap(map);
        PageInfo<Map<String, Object>> pageInfoList = new PageInfo<>(list);
        PageVO page = new PageVO();
        BeanUtils.copyProperties(clubLeaseVO, page);
        page.setQuery(list);
        page.setTotal((int) pageInfoList.getTotal());
        return page;
    }

    @Override
    public boolean delete(ClubLease clubLease) {
        clubLease.setStatus(Constants.Status.DELECT);
        ClubLease clubLease1 = clubLeaseDao.selectByPrimaryKey(clubLease.getClubid());
        Equipment equipment = equipmentService.selectByPrimaryKey(clubLease1.getEquipmentid());
        equipment.setNum(equipment.getNum() + clubLease1.getNum());
        equipmentService.updateByPrimaryKeySelective(equipment);
        return clubLeaseDao.updateByPrimaryKeySelective(clubLease) > 0;
    }
}
