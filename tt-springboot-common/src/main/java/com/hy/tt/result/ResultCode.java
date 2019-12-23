package com.hy.tt.result;

/**
 * @auther thy
 * @date 2019/12/12
 */
public enum ResultCode {
    SUCCESS(1,"成功");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
