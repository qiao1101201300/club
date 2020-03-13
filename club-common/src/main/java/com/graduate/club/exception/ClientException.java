package com.graduate.club.exception;


import com.graduate.club.enums.ResultEnum;
import lombok.Data;

/**
 * @Description: 客户端异常处理类
 * @Author:QS
 */

@Data
public class ClientException extends RuntimeException {

    private int code;
    private String msg;
    private Object data;

    public ClientException(ResultEnum enu) {
        super(enu.getMsg());
        this.code = enu.getCode();
        this.msg = enu.getMsg();
    }

    public ClientException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

}

