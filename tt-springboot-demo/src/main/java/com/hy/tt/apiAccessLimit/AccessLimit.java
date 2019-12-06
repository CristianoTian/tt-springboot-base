package com.hy.tt.apiAccessLimit;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface AccessLimit {

    int seconds();
    int maxCount();
    boolean needLogin() default true;
}
