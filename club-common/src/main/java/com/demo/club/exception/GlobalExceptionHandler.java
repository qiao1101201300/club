package com.demo.club.exception;

import com.demo.club.enums.ResultEnum;
import com.demo.club.util.ErrorUtils;
import com.demo.club.util.ResultUtils;
import com.demo.club.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.dao.DataAccessException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;


@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ShiroException.class)
    public ResultVO exceptionGet(ShiroException e) {
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
        log.error("[ShiroException error] e={}", ErrorUtils.getStackTrace(e));
        return ResultUtils.error(ResultEnum.INTERNAL_SERVER_ERROR.getCode(), msg);
    }

    @ExceptionHandler(ClientException.class)
    public ResultVO Client(ClientException e) {
        log.error("[ClientException error] e={}", ErrorUtils.getStackTrace(e));
        return ResultUtils.error(ResultEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
    }

    @ExceptionHandler(DataAccessException.class)
    public ResultVO DataAccess(DataAccessException e) {
        log.error("[DataAccessException error] e={}", ErrorUtils.getStackTrace(e));
        return ResultUtils.error(ResultEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
    }

    @ExceptionHandler(ServerException.class)
    public ResultVO Server(ServerException e) {
        System.out.println("捕获到了NullPointerException");
        log.error("[ServerException error] e={}", ErrorUtils.getStackTrace(e));
        return ResultUtils.error(ResultEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResultVO NullPointer(NullPointerException e) {
        System.out.println("捕获到了NullPointerException");
        log.error("[NullPointer error] e={}", ErrorUtils.getStackTrace(e));
        return ResultUtils.error(ResultEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
    }

    @ExceptionHandler(ClassCastException.class)
    public ResultVO ClassCastException(ClassCastException e) {
        log.error("[ClassCastException error] e={}", ErrorUtils.getStackTrace(e));
        return ResultUtils.error(ResultEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
    }

    @ExceptionHandler(IOException.class)
    public ResultVO IOException(IOException e) {
        log.error("[IOException error] e={}", ErrorUtils.getStackTrace(e));
        return ResultUtils.error(ResultEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultVO HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("[HttpRequestMethodNotSupportedException error] e={}", ErrorUtils.getStackTrace(e));
        return ResultUtils.error(ResultEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
    }


    @ExceptionHandler(RuntimeException.class)
    public ResultVO RuntimeException(RuntimeException e) {
        log.error("[RuntimeException error] e={}", ErrorUtils.getStackTrace(e));
        return ResultUtils.error(ResultEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResultVO exception(Exception e) {
        log.error("[Exception error] e={}", ErrorUtils.getStackTrace(e));
        return ResultUtils.error(ResultEnum.INTERNAL_SERVER_ERROR.getCode(), e.getMessage());
    }
}
