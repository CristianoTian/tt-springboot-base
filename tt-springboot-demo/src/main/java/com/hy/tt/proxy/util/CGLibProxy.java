package com.hy.tt.proxy.util;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @auther thy
 * @date 2019/9/25
 */
public class CGLibProxy implements MethodInterceptor {

    private Object targetObject;

    public Object createProxyObject(Object obj){
        this.targetObject = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);
        Object o = enhancer.create();
        return o;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object obj = null;

        checkPopedom();

        obj = method.invoke(targetObject, objects);

        return obj;
    }


    private void checkPopedom() {
        System.out.println("======检查权限checkPopedom()======");
    }

}
