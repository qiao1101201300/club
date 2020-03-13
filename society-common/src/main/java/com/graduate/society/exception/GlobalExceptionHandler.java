package com.graduate.society.exception;

import com.graduate.society.enums.ResultEnum;
import com.graduate.society.util.ResultUtils;
import com.graduate.society.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.io.IOException;

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


        log.error("[Unknown error] errMSg={}", e.toString());
        return ResultUtils.error(ResultEnum.ERROR.getCode(), "未知错误");
    }
}
