package com.hy.tt;

import com.hy.tt.result.DataResult;
import com.hy.tt.result.ResultCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther thy
 * @date 2020/3/25
 */
@ControllerAdvice
public class ExceptionAdviceHandler {

    @ResponseBody
    @ExceptionHandler(value = TTException.class)
    public DataResult TTExceptionHandler(TTException ex){
        return new DataResult(ex.getCode(),ex.getMessage());
    }
}
