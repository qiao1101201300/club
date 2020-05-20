package com.demo.club.exception;

import com.demo.club.enums.ResultEnum;
import com.demo.club.util.ResultUtils;
import com.demo.club.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends RuntimeException {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultVO exceptionGet(Exception e) {
        //客户端异常
        if (e instanceof ClientException) {
            ClientException exception = (ClientException) e;
            log.error("[Client error] code={},msg={}", exception.getCode(), exception.toString());
            return ResultUtils.error(exception.getCode(), exception.getMsg(), exception.getData());
        }
        //
        if (e instanceof DataAccessException) {
            DataAccessException exception = (DataAccessException) e;
            log.error("[Database operation error] msg={}", exception.toString());
            return ResultUtils.error(ResultEnum.DB_ERROR.getCode(), exception.getMessage());
        }

        if (e instanceof ServerException) {
            ServerException exception = (ServerException) e;
            log.error("[Server error] code={},msg={}", exception.getCode(), exception.toString());
            return ResultUtils.error(ResultEnum.INTERNAL_SERVER_ERROR.getCode(), exception.getMsg(), exception.getData());
        }

        if (e instanceof IOException) {
            IOException exception = (IOException) e;
            log.error("[Io error] msg={}", exception.toString());
            return ResultUtils.error(ResultEnum.INTERNAL_SERVER_ERROR.getCode(), exception.getMessage());
        }
        if (e instanceof AuthorizationException) {
            Map<String, String> result = new HashMap<String, String>();
            result.put("status", "400");
            //获取错误中中括号的内容
            String message = e.getMessage();
            String msg = message.substring(message.indexOf("[") + 1, message.indexOf("]"));
            //判断是角色错误还是权限错误
            if (message.contains("role")) {
                msg = "对不起，您没有" + msg + "角色";
            } else if (message.contains("permission")) {
                msg = "对不起，您没有" + msg + "权限";
            } else {
                msg = "对不起，您的权限有误";
            }
            return ResultUtils.error(ResultEnum.INTERNAL_SERVER_ERROR.getCode(), msg);
        }
        log.error("[Unknown error] errMSg={}", e.toString());
        return ResultUtils.error(ResultEnum.ERROR.getCode(), "未知错误");
    }
}
