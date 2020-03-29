/**
 * Copyright 2000-2012 DigitalChina. All Rights Reserved.
 */
package com.graduate.club.util;


public final class Constants {

    public final class UserStatus {
        public static final int NORMAL = 0;  //正常
        public static final int FORBID = 1; // 禁止
    }

    public final class Status {
        public static final int DELECT = 0;  //退出
        public static final int INIT = 1; //审核
        public static final int SUCCESS = 2; //成功
    }

    public final class Role {
        public static final String SYSTEMADMIN = "系统管理员";
        public static final String CLUBMADMIN = "社团管理员";
        public static final String ORDINARYADMIN = "普通用户";
    }

    public final class User {
        public static final String COOKIE_USER = "USER";
        public static final String COOKIE_ADMIN = "ADMIN";
    }
}
