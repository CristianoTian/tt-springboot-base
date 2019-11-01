package com.hy.tt;

import com.hy.tt.framework.servlet.TTDispatcherServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * @auther thy
 * @date 2019/10/23
 */
public class MyWebApplicationInitializer  implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) {

        System.out.println("tomcat ---- init");

        // Create and register the DispatcherServlet
        TTDispatcherServlet servlet = new TTDispatcherServlet();
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/*");




    }
}
