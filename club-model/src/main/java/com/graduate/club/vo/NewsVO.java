package com.graduate.club.vo;

import lombok.Data;

@Data
public class NewsVO {
    private String name;
    private Integer status;
    private int pageNum = 1;
    private int pageSize = 10;
}
