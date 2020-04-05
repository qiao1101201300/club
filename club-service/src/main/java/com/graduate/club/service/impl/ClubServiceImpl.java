package com.graduate.club.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduate.club.dao.ClubDao;
import com.graduate.club.mapper.ClubMapper;
import com.graduate.club.util.StringUtils;
import com.graduate.club.vo.ClubVO;
import com.graduate.club.vo.PageVO;
import com.graduate.club.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduate.club.entity.Club;
import com.graduate.club.service.ClubService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ClubServiceImpl extends BaseServiceImpl<Club, ClubDao> implements ClubService {

    @Autowired
    private ClubDao clubDao;


    @Override
    public List<Club> selectAllClubByUserId(String userId) {
        return clubDao.selectAllClubByUserId(userId);
    }

    @Override
    public Club selectClubByUserId(String userId) {
        return (Club) clubDao.selectClubByUserId(userId);
    }

    @Override
    public PageVO selectClubUserByClubid(String clubid, int status) {
        return clubDao.selectClubUserByClubid(clubid, status);
    }

    @Override
    public PageVO selectByMap(ClubVO clubVO) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isNotBlank(clubVO.getClubName())) {
            map.put("clubName", clubVO.getClubName());
        }
        if (StringUtils.isNotBlank(clubVO.getPrincipalName())) {
            map.put("principalName", clubVO.getPrincipalName());
        }
        if (clubVO.getStar() != null) {
            map.put("star", clubVO.getStar());
        }
        map.put("status",clubVO.getStatus());
        PageHelper.startPage(clubVO.getPageNum(), clubVO.getPageSize() == 0 ? 10 : clubVO.getPageSize());
        List<Map<String, Object>> mapList = clubDao.selectByMap(map);
        PageInfo<Map<String, Object>> pageInfoList = new PageInfo<>(mapList);
        PageVO page = new PageVO();
        BeanUtils.copyProperties(clubVO, page);
        page.setQuery(mapList);
        page.setTotal((int) pageInfoList.getTotal());
        return page;
    }
}
