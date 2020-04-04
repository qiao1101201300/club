package com.graduate.club.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.graduate.club.dao.DepartmentDao;
import com.graduate.club.entity.Department;
import com.graduate.club.service.DepartmentService;
import com.graduate.club.util.StringUtils;
import com.graduate.club.vo.DepartmentVO;
import com.graduate.club.vo.PageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentServiceImpl extends BaseServiceImpl<Department, DepartmentDao> implements DepartmentService {

    @Resource
    private DepartmentDao departmentDao;

    @Override
    public PageVO selectByMap(DepartmentVO departmentVO) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isBlank(departmentVO.getDepartmentName())) {
            map.put("departmentName", departmentVO.getDepartmentName());
        }
        if (StringUtils.isBlank(departmentVO.getUsername())) {
            map.put("username", departmentVO.getUsername());
        }
        if (departmentVO.getStatus() != null) {
            map.put("status", departmentVO.getStatus());
        }
        PageHelper.startPage(departmentVO.getPageNum(), departmentVO.getPageSize() == 0 ? 10 : departmentVO.getPageSize());
        List<Map<String, Object>> mapList = departmentDao.selectByMap(map);
        PageInfo<Map<String, Object>> pageInfoList = new PageInfo<>(mapList);
        PageVO page = new PageVO();
        BeanUtils.copyProperties(departmentVO, page);
        page.setQuery(mapList);
        page.setTotal((int) pageInfoList.getTotal());
        return page;
    }
}


