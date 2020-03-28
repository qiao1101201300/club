package com.graduate.club.entity;

import lombok.Data;

@Data
public class News extends BaseEntity {
    /**
     * 新闻标题
     */
    private String name;

    /**
     * 用户id
     */
    private String userid;

    /**
     * 评审人id
     */
    private String adminid;

    /**
     * 社团id
     */
    private String clubid;

    /**
     * 状态(0:删除;1:审核;2:成功)
     */
    private Integer status;

    /**
     * 新闻内容
     */
    private String content;

}