package com.hy.tt.proxy.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @auther thy
 * @date 2019/9/25
 */
public class JDKProxy implements InvocationHandler {

    //需要代理的目标对象
    private Object targetObject;

    //构造传入代理的目标对象,并返回代理对象
    public Object newProxy( Object targetObject) {
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),targetObject.getClass().getInterfaces(),this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        checkPopedom();

        Object ret = null;

        ret = method.invoke(targetObject,args);

        return ret;
    }

    /**
     * 模拟检查权限的例子
     */
    private void checkPopedom() {
        System.out.println("======检查权限checkPopedom()======");
    }

}
