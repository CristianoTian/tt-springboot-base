# tt-spring-mvcToboot


springMvc到springboot演变

servlet3.0 后有一个规则, 就是会加载所有 实现了 WebApplicationInitializer 接口的 onStartUp 方法


1.编写自己的application 实现WebApplicationInitializer 的 onstartUp方法
	方法中是启动springMvc的方法 
	
2.启动springMVC方法在 官网有 xml  和 config   

    public class MyWebApplicationInitializer implements WebApplicationInitializer {

        @Override
        public void onStartup(ServletContext servletCxt) {
    
            // Load Spring web application configuration
            AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
            ac.register(AppConfig.class);
            ac.refresh();
    
            // Create and register the DispatcherServlet
            DispatcherServlet servlet = new DispatcherServlet(ac);
            ServletRegistration.Dynamic registration = servletCxt.addServlet("app", servlet);
            registration.setLoadOnStartup(1);
            registration.addMapping("/app/*");
        }
    }


3.创建 springApplication 类  并且仿照 springBoot的run方法   创建run 方法


4.run 方法  启动  tomcat

    Tomcat tomcat = new Tomcat();
    tomcat.setPort(8080);
    tomcat.addWebapp("/",""");
    
    tomcat.start();
    tomcat.getServer().await();


5.创建Test类 main 调用 自我创建的springApplication 的run 方法