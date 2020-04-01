package com.graduate.club.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class News extends BaseEntity {
    /**
     * 新闻标题
     */
    @NotBlank(message = "新闻标题不能为空")
    private String name;

    /**
     * 用户id
     */
    @NotBlank(message = "用户id不能为空")
    private String userid;

    /**
     * 评审人id
     */
    @NotBlank(message = "评审人id不能为空")
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
    @NotBlank(message = "评审人id不能为空")
    private String content;

}