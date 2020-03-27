package com.hy.tt;

/**
 * @auther thy
 * @date 2020/3/25
 */
public class TTException extends RuntimeException {

    private String code;
    private String message;

    public TTException(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
