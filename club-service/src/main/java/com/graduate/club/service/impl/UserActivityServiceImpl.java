package com.graduate.club.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduate.club.dao.UserActivityDao;
import com.graduate.club.entity.UserActivity;
import com.graduate.club.service.UserActivityService;
import com.graduate.club.util.StringUtils;
import com.graduate.club.vo.PageVO;
import com.graduate.club.vo.UserActivityVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserActivityServiceImpl extends BaseServiceImpl<UserActivity,UserActivityDao> implements UserActivityService {

    @Autowired
    private UserActivityDao userActivityDao;


    @Override
    public PageVO selectByMap(UserActivityVO userActivityVO) {
        Map<String,Object> map = new HashMap<>();
        if (StringUtils.isNotBlank(userActivityVO.getActicityName())){
            map.put("acticityName",userActivityVO.getActicityName());
        }
        if (StringUtils.isNotBlank(userActivityVO.getUsername())){
            map.put("username",userActivityVO.getUsername());
        }
        if (userActivityVO.getStatus() != null){
            map.put("status",userActivityVO.getStatus());
        }
        PageHelper.startPage(userActivityVO.getPageNum(), userActivityVO.getPageSize() == 0 ? 10 : userActivityVO.getPageSize());
        List<Map<String,Object>> mapList = userActivityDao.selectByMap(map);
        PageInfo<Map<String, Object>> pageInfoList = new PageInfo<>(mapList);
        PageVO page = new PageVO();
        BeanUtils.copyProperties(userActivityVO, page);
        page.setQuery(mapList);
        page.setTotal((int) pageInfoList.getTotal());
        return page;
    }
}
