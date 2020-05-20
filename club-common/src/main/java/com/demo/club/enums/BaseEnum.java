package com.demo.club.enums;

/**
 * @Description: ${枚举基类}
 * @Author:QS
 */

public interface BaseEnum<T> {
    T getCode();

    String getMsg();
}

