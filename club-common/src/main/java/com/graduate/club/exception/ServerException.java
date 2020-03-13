package com.graduate.club.exception;


import com.graduate.club.enums.ResultEnum;
import lombok.Data;

/**
 * 服务端错误
 */
@Data
public class ServerException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private int code;
    private String msg;
    private Object data;

    public ServerException(ResultEnum enu) {
        super(enu.getMsg());
        this.code = enu.getCode();
        this.msg = enu.getMsg();
    }

    public ServerException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
