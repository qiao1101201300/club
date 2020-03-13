package com.graduate.club.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = -4052705808523280313L;
    private String id;
    private Date createAt;
    private Date updateAt;

}
