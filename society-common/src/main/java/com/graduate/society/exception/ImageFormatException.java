package com.graduate.society.exception;

public class ImageFormatException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ImageFormatException(Exception e) {
        super(e);
    }

    public ImageFormatException(String msg, Exception e) {
        super(msg, e);
    }

    public ImageFormatException(String msg) {
        super(msg);
    }

    private int code;
    private String msg;

    public ImageFormatException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
