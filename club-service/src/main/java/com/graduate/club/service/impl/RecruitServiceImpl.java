package com.graduate.club.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduate.club.dao.RecruitDao;
import com.graduate.club.entity.Recruit;
import com.graduate.club.service.RecruitService;
import com.graduate.club.util.StringUtils;
import com.graduate.club.vo.PageVO;
import com.graduate.club.vo.RecruitVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecruitServiceImpl extends BaseServiceImpl<Recruit, RecruitDao> implements RecruitService {

    @Autowired
    private RecruitDao recruitDao;

    @Override
    public PageVO selectByMap(RecruitVO recruitVO) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isNotBlank(recruitVO.getName())) {
            map.put("name", recruitVO.getName());
        }
        if (recruitVO.getOpenDate() != null) {
            map.put("openDate", recruitVO.getOpenDate());
        }
        if (recruitVO.getCloseDate() != null) {
            map.put("closeDate", recruitVO.getCloseDate());
        }
        if (recruitVO.getStatus() != null) {
            map.put("status", recruitVO.getStatus());
        }
        PageHelper.startPage(recruitVO.getPageNum(), recruitVO.getPageSize() == 0 ? 10 : recruitVO.getPageSize());
        List<Map<String,Object>> mapList = recruitDao.selectByMap(map);
        PageInfo<Map<String, Object>> pageInfoList = new PageInfo<>(mapList);
        PageVO page = new PageVO();
        BeanUtils.copyProperties(recruitVO, page);
        page.setQuery(mapList);
        page.setTotal((int) pageInfoList.getTotal());
        return page;
    }

    @Override
    public Recruit selectByClubId(String clubid) {
        return recruitDao.selectByClubId(clubid);
    }
}
