package com.hy.tt.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @auther thy
 * @date 2019/9/23
 */
public class Status implements Serializable {
    private static final long serialVersionUID = 529214920069625874L;

    @JsonProperty("statusCode")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int statusCode = 0;

    @JsonProperty("statusReason")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String statusReason;

    public Status() {

    }

    public Status(int statusCode, String message) {

        this.statusCode = statusCode;
        this.statusReason = message;
    }

    @Override
    public String toString() {
        return "{\"statusCode\":" + statusCode + ",\"statusReason\":\"" + statusReason + "\"}";
    }

    public int getStatusCode() {
        return statusCode;
    }

    /**
     * 注意该种方式只在是使用序列化框架是使用，如果编码是调用请使用
     * <p/>
     * <code>
     * setStatusCode(int statusCode, boolean appendSysCode)
     * </code>
     *
     * @param statusCode
     */
    @SuppressWarnings("unused")
    private void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }


    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }
}
