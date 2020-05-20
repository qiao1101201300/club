/**
 * Copyright 2000-2012 DigitalChina. All Rights Reserved.
 */
package com.demo.club.util;


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

    public final class User {
        public static final String COOKIE_USER = "USER";
        public static final String COOKIE_ADMIN = "ADMIN";
    }
    public final class Level {
        public static final int ORDINARYUSERS = 0;  //正常
        public static final int ADMINISTRATOR = 1; // 禁止
    }
}
