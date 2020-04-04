package com.graduate.club.dao.impl;

import com.graduate.club.dao.DepartmentDao;
import com.graduate.club.entity.Department;
import com.graduate.club.mapper.DepartmentMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository
public class DepartmentDaoImpl extends BaseDaoImpl<Department,DepartmentMapper> implements DepartmentDao {

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public List<Map<String, Object>> selectByMap(Map<String, Object> map) {
        return departmentMapper.selectByMap(map);
    }
}


