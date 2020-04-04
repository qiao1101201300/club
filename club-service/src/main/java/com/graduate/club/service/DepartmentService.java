package com.graduate.club.service;

import com.graduate.club.entity.Department;
import com.graduate.club.vo.DepartmentVO;
import com.graduate.club.vo.PageVO;

public interface DepartmentService extends BaseService<Department> {

    PageVO selectByMap(DepartmentVO departmentVO);
}


