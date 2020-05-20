package com.demo.club.util;


import com.demo.club.enums.ResultEnum;
import com.demo.club.vo.ResultVO;

/**
 * @Description: ${todo}
 * @Author:Frederic-YYW
 * @Email:yuanyangwen@iristar.com.cn
 * @Date 2019-04-10 15:35
 */
public class ResultUtils {

    public static ResultVO error(int code, String msg) {
        return new ResultVO(code, msg, null);
    }

    public static ResultVO error(int code, String msg, Object data) {
        return new ResultVO(code, msg, data);
    }

    public static ResultVO success() {
        return new ResultVO(ResultEnum.SUCCESS.getCode(), "success", null);
    }

    public static ResultVO success(int code) {
        return new ResultVO(code, "success", null);
    }

    public static ResultVO success(Object data) {
        return new ResultVO(ResultEnum.SUCCESS.getCode(), "success", data);
    }


    public static ResultVO fail(int code) {
        return new ResultVO(code, "fail", null);
    }

    public static ResultVO fail(int code, String msg) {
        return new ResultVO(code, msg, null);
    }

    public static ResultVO error(Object data) {
        return new ResultVO(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getMsg(), data);
    }

    public static ResultVO error(ResultEnum resultEnum) {
        return error(resultEnum.getCode(), resultEnum.getMsg());
    }
}
