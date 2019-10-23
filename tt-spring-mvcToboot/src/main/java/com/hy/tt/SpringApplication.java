package com.hy.tt;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;


/**
 * @auther thy
 * @date 2019/10/23
 */
public class SpringApplication {

    public static void  run (){
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9090);

        tomcat.addWebapp("/","c:\\test\\");

        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
