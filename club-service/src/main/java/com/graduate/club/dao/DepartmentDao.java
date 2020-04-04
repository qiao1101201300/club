package com.graduate.club.dao;

import com.graduate.club.entity.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentDao extends BaseDao<Department> {

    List<Map<String, Object>> selectByMap(Map<String, Object> map);
}


