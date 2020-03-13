package com.graduate.society.enums;

/**
 * @Description: ${枚举基类}
 * @Author:QS
 */

public interface BaseEnum<T> {
    T getCode();

    String getMsg();
}

