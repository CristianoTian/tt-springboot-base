package com.hy.tt.result;

/**
 * @auther thy
 * @date 2020/3/25
 */
public class DataResult {

    private String code;

    private String message;


    public DataResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
