package com.hy.tt.proxy;

import com.hy.tt.proxy.service.HelloServiceImpl;
import com.hy.tt.proxy.service.IHelloService;
import com.hy.tt.proxy.util.CGLibProxy;
import com.hy.tt.proxy.util.JDKProxy;

/**
 * @auther thy
 * @date 2019/9/25
 */
public class TestProxy {

    public static void main(String[] args) {
        System.out.println("**********************JDKProxy**********************");
        JDKProxy jdkPrpxy = new JDKProxy();
        IHelloService helloServiceJDK = (IHelloService) jdkPrpxy.newProxy(new HelloServiceImpl());
        String hello = helloServiceJDK.say("JDK hello");
        System.out.println("return result: " + hello);


        System.out.println("**********************CGLibProxy**********************");
        CGLibProxy cgLibProxy = new CGLibProxy();
        IHelloService helloServiceCGLib =  (IHelloService)cgLibProxy.createProxyObject(new HelloServiceImpl());
        String cgLib_hello = helloServiceCGLib.say("CGLib Hello");
        System.out.println("return result: " + cgLib_hello);


    }
}
