package com.graduate.club.mapper;

import com.graduate.club.entity.Department;

import java.util.List;
import java.util.Map;

public interface DepartmentMapper extends BaseMapper<Department> {

    List<Map<String, Object>> selectByMap(Map<String, Object> map);
}