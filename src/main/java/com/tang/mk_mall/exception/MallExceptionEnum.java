package com.tang.mk_mall.exception;

/**
 * 异常枚举
 */
public enum MallExceptionEnum {
    NEED_USER_NAME(1001, "用户名不能为空"),
    NEED_PASSWORD(1002, "密码不能为空"),
    PASSWORD_TOO_SHORT(1003, "密码长度不能少于8位"),
    NAME_EXISTED(1004, "不允许重名，注册失败"),
    INSERT_FAILED(1004, "插入失败，请重试");

    /**
     * 异常码
     */
    Integer code;
    /**
     * 异常信息
     */
    String msg;

    MallExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
