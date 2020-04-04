package com.graduate.club.vo;

import lombok.Data;

@Data
public class ReviewVO {
    private String clubName;
    private Integer star;
    private String adminName;
    private int pageSize = 10;
    private int pageNum = 1;
}
