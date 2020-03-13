/**
 * Copyright 2000-2012 DigitalChina. All Rights Reserved.
 */
package com.graduate.society.util;


public final class Constants {

    public final class UserStatus {
        public static final int NORMAL = 0;  //正常
        public static final int FORBID = 1; // 禁止
    }

    public final class UserProfileStatus {
        public static final int INIT = 0;    //
        public static final int NORMAL = 1;  //正常
    }

    public final class Role {
        public static final String SYSTEMADMIN = "系统管理员";
        public static final String CLUBMADMIN = "社团管理员";
        public static final String ORDINARYADMIN="普通用户";
    }

    public final class JobStatus {
        public static final int SUBMIT = 0;  //提交
        public static final int SUCCESS = 1; //成功
        public static final int FAILED = 2;  //失败
        public static final int REJECT = 3;   //拒绝
        public static final int CLOSE = 4;   //关闭
    }

    public final class JobFileType {
        public static final String ALGORITHM = "algorithm"; //算法库
        public static final String CONFIG = "shiro"; //配置文件
        public static final String LOG = "log"; //日志文件
        public static final String IMAGE = "image"; //异常图片
        public static final String SCENE_IMAGE = "scene_image"; //现场图片
        public static final String DESC = "desc"; //描述文件
        public static final String DB = "db"; //描述文件
        public static final String RESULT = "result";
    }

    public final class ResCode {
        public static final int NOT_LOGIN = 101;  //用户未登录
        public static final int TOKEN_ERROR = 102; //token错误
        public static final int USER_NOT_FOUND = 103; //用户不存在
        public static final int PASSWORD_ERROR = 104; //密码错误
        public static final int USERNAME_EXISTS = 105;//用户名已存在
        public static final int PASSWORD_SAME_AS_OLDPASS = 106;//新密码与老密码相同
        public static final int USER_FORBID = 107;//用户被禁用
        public static final int TOKEN_EXPIRED = 108; //token过期
        public static final int CARD_EXIST = 109;

        public static final int SUCCESS = 200;   //成功
        public static final int OFFLINE_SUCCESS = 201;//离线保存成功


        public static final int PARAM_ERROR = 301;//参数错误
        public static final int PARAM_NOT_FOUND = 302; //参数或配置未找到
        public static final int DB_SAVE_FAILED = 303;  //数据保存失败
        public static final int SYNC_FAILED = 304;  //同步记录到远程失败

        public static final int NETWORK_ERROR = 401; //网络连接失败或超时
        public static final int INTERNAL_SERVER_ERROR = 500; //服务内部错误
        public static final int ERROR = 400; //错误

        //注册返回码
        public static final int REG_IRIS_SUCCESS = 310;      //虹膜注册成功
        public static final int REG_IRIS_EXISTS = 311;      //虹膜已存在
        public static final int REG_IRIS_IDCARD_ERROR = 312; // 证件信息不一致
        public static final int REG_IRIS_IDCARD_EXIST = 313; // 证件已注册
        public static final int REG_NO_IRIS_IDCARD_EXIST = 314; // 证件已注册,虹膜未找到
        public static final int REG_IRIS_UNKNOWN_ERROR = 315; // 未知错误

    }

    public final class User {
        public static final String COOKIE_USER = "USER";
    }

    public final class jsonView {
        public static final int CODE_SUCCESS = 200;
        public static final int CODE_FAILED = 400;

        public static final String STATUS_SUCCESS = "success";
        public static final String STATUS_FAIL = "fail";
        public static final String NONE_LOGIN = "none_login";

        public static final String ERRMSG_PAGE = "分页信息为空";
        public static final String ERRMSG_ID = "主键ID为空";
        public static final String ERRMSG_OBJ = "对象为空";
    }
}
