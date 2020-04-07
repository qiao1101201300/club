package com.graduate.club.vo;

import lombok.Data;

@Data
public class EquipmentVO {
    private String name;
    private Integer num;
    private int pageNum = 1;
    private int pageSize = 10;
}
