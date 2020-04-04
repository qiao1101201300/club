package com.graduate.club.vo;

import lombok.Data;

@Data
public class DepartmentVO {
    private String departmentName;
    private String username;
    private Integer status;
    private int pageSize = 10;
    private int pageNum = 1;
}
