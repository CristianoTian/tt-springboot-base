package com.hy.tt.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @auther thy
 * @date 2019/9/23
 */
public class DataResult<T>  {

    /**
     * 解析协议状态码
     */
    @JsonProperty("status")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Status status = new Status(0, "");
    /**
     * 返回Result
     */
    @JsonProperty("result")
    private T result;


}
