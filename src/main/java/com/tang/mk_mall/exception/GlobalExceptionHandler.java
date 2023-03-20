package com.tang.mk_mall.exception;

import com.tang.mk_mall.common.ApiRestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 处理统一异常的 handler
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // 系统异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handleException(Exception e) {
        log.error("Default Exception: ", e);
        return ApiRestResponse.error(MallExceptionEnum.SYSTEM_ERROR);
    }

    // 业务异常
    @ExceptionHandler(MallException.class)
    @ResponseBody
    public ApiRestResponse handleMallException(MallException e) {
        log.error("MallException: ", e);
        return ApiRestResponse.error(e.getCode(), e.getMessage());
    }

}
