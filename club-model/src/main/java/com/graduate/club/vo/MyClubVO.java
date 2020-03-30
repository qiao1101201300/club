package com.graduate.club.vo;

import lombok.Data;

@Data
public class MyClubVO {
    //社团名称
    private String clubName;
    //当前负责人
    private String nowPrincipal;
    //社团星级数
    private int clubStar;
    //全年活动总数
    private int sumActive;
}
