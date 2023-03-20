package com.tang.mk_mall.exception;

/**
 * 统一异常
 */
public class MallException extends Exception {

    private final Integer code;
    private final String msg;

    public MallException(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public MallException(MallExceptionEnum exceptionEnum) {
        this(exceptionEnum.getCode(), exceptionEnum.getMsg());
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
