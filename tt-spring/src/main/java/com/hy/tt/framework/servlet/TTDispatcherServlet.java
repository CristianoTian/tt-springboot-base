package com.hy.tt.framework.servlet;

import com.hy.tt.framework.annotation.TTAutowired;
import com.hy.tt.framework.annotation.TTController;
import com.hy.tt.framework.annotation.TTRequestMapping;
import com.hy.tt.framework.annotation.TTService;
import org.omg.CORBA.Current;
import org.springframework.web.servlet.FrameworkServlet;
import sun.plugin.net.protocol.jar.CachedJarURLConnection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @auther thy
 * @date 2019/11/1
 */
public class TTDispatcherServlet extends FrameworkServlet {


    private static final long serialVersionUID = -7149538178380995512L;

    //web.xml中的param-name的值一致
    private static final String LOACTION = "application.properties";
    private static final String SCAN = "scanPackage";

    //保存所有的配置
    private Properties p = new Properties();

    //保存所有呗扫描到的相关类名
    private List<String> classNames = new ArrayList<String>();

    //核心IOC容器,保存所有的bean
    private ConcurrentHashMap<String,Object> ioc = new ConcurrentHashMap<String,Object>();

    //保存所有的url和方法的映射关系
    private Map<String, Method> handlerMapping = new HashMap<String, Method>();

    public TTDispatcherServlet() {
        super();
    }

    public void  init(ServletConfig config){

        //加载配置文件
        doLoadConfig(LOACTION);

        //扫描所有相关类
        doScanner(p.getProperty(SCAN));

        //初始化bean放入到IOC容器
        doInstance();

        //依赖注入
        doAutowired();

        //构造HandlerMapping
        initHandlerMapping();

        System.out.println("mvc framework is init");
    }

    protected void doLoadConfig(String location){
        InputStream  fis = null;
        try{
            fis = this.getClass().getClassLoader().getResourceAsStream(location);
            p.load(fis);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(null != fis){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doScanner(String packageName){
        URL resource = this.getClass().getClassLoader().getResource(packageName.replaceAll("\\.", "/"));
        File dir = new File(resource.getFile());
        for(File file : dir.listFiles()) {
            if (file.isDirectory()) {
                doScanner(packageName + "." + file.getName());
            }else{
                if(!file.getName().endsWith(".class")){continue;}
                classNames.add(packageName+"."+ file.getName().replace(".class","").trim());
            }
        }
    }

    protected void doInstance(){
        try{
            for(String className : classNames){
                Class<?> aClass = Class.forName(className);

                //判断注解
                if(aClass.isAnnotationPresent(TTController.class)){
                    String beanName = lowerFirstCase(aClass.getSimpleName());
                    Object instance = aClass.newInstance();
                    ioc.put(beanName,instance);
                }else if (aClass.isAnnotationPresent(TTService.class)){
                    TTService annotation = aClass.getAnnotation(TTService.class);
                    String beanName = annotation.value();
                    if("".equals(beanName)){
                        beanName = lowerFirstCase(aClass.getSimpleName());
                    }
                    Object instance = aClass.newInstance();
                    ioc.put(beanName,instance);

                    // 获取该实现类的所有接口
                    for (Class<?> i : aClass.getInterfaces()){
                        // 判断接口是否有多个实现类
                        if(ioc.containsKey(i.getName())){
                            throw new Exception("The beanName " +i.getName()+" is exists!!!" );
                        }
                        ioc.put(i.getName(),instance);
                    }

                }
            }
        }catch (Exception e){

        }

    }

    protected void doAutowired() {
        if(ioc.isEmpty()){return;}

        // 循环ioc容器的实例
        for (Map.Entry<String ,Object> entry : ioc.entrySet()){
            // 所有字段，public,protected,private default类型
            Field[] fields = entry.getValue().getClass().getDeclaredFields();
            for (Field field : fields){
                // 字段没有加Autowired注解则跳过
                if(!field.isAnnotationPresent(TTAutowired.class)){continue;}

                TTAutowired autowired = field.getAnnotation(TTAutowired.class);
                // Autowired上定义的name
                String beanName = autowired.value();
                if("".equals(beanName)){
                    beanName = field.getType().getName();
                }

                // 强制给字段赋值,面向对象原则不允许更改私有属性
                field.setAccessible(true);
                try {
                    // 给字段注入属性，完成依赖注入
                    field.set(entry.getValue(),ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private void initHandlerMapping() {
        if(ioc.isEmpty()){return;}

        // 循环ioc容器的实例
        for (Map.Entry<String ,Object> entry : ioc.entrySet()){
            Class<?> clazz = entry.getValue().getClass();
            // 跳过没有加Controller注解的类
            if(!clazz.isAnnotationPresent(TTController.class)){continue;}

            String baseUrl = "";
            // 获取Controller的url
            if(clazz.isAnnotationPresent(TTRequestMapping.class)){
                TTRequestMapping requestMapping = clazz.getAnnotation(TTRequestMapping.class);
                baseUrl = requestMapping.value();
            }

            // 获取Controller下所有的public方法
            Method[] methods = clazz.getMethods();
            for (Method method : methods){
                // 跳过没有加RequestMapping注解的方法
                if(!method.isAnnotationPresent(TTRequestMapping.class)){continue;}

                // 获取method的url
                TTRequestMapping requestMapping = method.getAnnotation(TTRequestMapping.class);
                // 避免出现//的形式，将多个/格式化（/+代表多个/）
                String url = ("/"+baseUrl+"/"+requestMapping.value()).replaceAll("/+","/");
                handlerMapping.put(url,method);
                System.out.println("Mapped "+url+":"+method);
            }
        }
    }



    @Override
    protected void doService(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        // 分发请求，根据url找到method
        try {
            doDispatcher(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.getWriter().write("500 Exception "+Arrays.toString(e.getStackTrace()));
        }
    }

    private void doDispatcher(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        if(handlerMapping.isEmpty()){return;}

        String url = req.getRequestURI();
        // 上下文绝对路径
        String contextPath = req.getContextPath();
        // 获取相对路径
        url = url.replace(contextPath,"").replaceAll("/+","/");
        // 映射到具体方法
        Method method = this.handlerMapping.get(url);

        if(method != null){
            // // 获取beanName,spring不是这么做的
            String beanName = lowerFirstCase(method.getDeclaringClass().getSimpleName());
            // 入参
            Map<String,String[]> params = req.getParameterMap();
            if(params.size() == 0){
                method.invoke(ioc.get(beanName));
            }else{
                // 反射调用
                method.invoke(ioc.get(beanName),new Object[]{req,resp,params.get("name")[0]});
            }
        }

    }

    private String lowerFirstCase(String str){
        char[] chars = str.toCharArray();
        chars[0] +=32;
        return String.valueOf(chars);
    }

}
