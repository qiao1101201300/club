package com.graduate.club.vo;

import lombok.Data;

@Data
public class UserActivityVO {
    private String username;
    private String acticityName;
    private Integer status;
    private int pageSize = 10;
    private int pageNum = 1;
}
