package com.graduate.club.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduate.club.dao.ActivityDao;
import com.graduate.club.util.Constants;
import com.graduate.club.util.StringUtils;
import com.graduate.club.vo.ActivityVO;
import com.graduate.club.vo.PageVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduate.club.entity.Activity;
import com.graduate.club.service.ActivityService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ActivityServiceImpl extends BaseServiceImpl<Activity, ActivityDao> implements ActivityService {

    @Autowired
    private ActivityDao activityDao;

    @Override
    public int sumActivity(String clubId) {

        return activityDao.sumActivity(clubId);
    }

    @Override
    public PageVO selectActivity(ActivityVO activityVO) {
        Map<String, Object> map = new HashMap();
        if (activityVO.getOpenDate() != null) {
            map.put("openDate", activityVO.getOpenDate());
        }
        if (activityVO.getCloseDate() != null) {
            map.put("closeDate", activityVO.getCloseDate());
        }
        if (StringUtils.isNotBlank(activityVO.getName())) {
            map.put("name", activityVO.getName());
        }
        if (StringUtils.isNotBlank(activityVO.getUserid())) {
            map.put("usrid", activityVO.getUserid());
        }
        PageHelper.startPage(activityVO.getPageNum(), activityVO.getPageSize() == 0 ? 10 : activityVO.getPageSize());
        List<Map<String, Object>> list = activityDao.selectActivity(map);
        PageInfo<Map<String, Object>> pageInfoList = new PageInfo<>(list);
        PageVO page = new PageVO();
        BeanUtils.copyProperties(list, page);
        page.setQuery(list);
        page.setTotal((int) pageInfoList.getTotal());
        return page;
    }

    @Override
    public boolean create(Activity activity) {
        activity.setStatus(Constants.Status.INIT);
        return activityDao.insertSelective(activity) > 0;
    }
}
