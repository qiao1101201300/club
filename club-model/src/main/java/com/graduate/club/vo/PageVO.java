package com.graduate.club.vo;

import lombok.Data;

@Data
public class PageVO {
    private int pageSize = 10;
    private int pageNum = 0;
    private int total = 0;
    private int totalPageNum = 0;
    private int offset = 0;
    private Object query;
}
