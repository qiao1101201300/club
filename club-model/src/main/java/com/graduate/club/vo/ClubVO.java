package com.graduate.club.vo;

import lombok.Data;

@Data
public class ClubVO {
    private String clubName;
    private String principalName;
    private Integer star;
    private Integer status;
    private int pageSize = 10;
    private int pageNum = 1;
}
