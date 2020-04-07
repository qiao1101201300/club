package com.graduate.club.vo;

import lombok.Data;

@Data
public class ClubLeaseVO {
    private String clubName;
    private String clubLeaseName;
    private int pageNum = 1;
    private int pageSize = 10;
}
