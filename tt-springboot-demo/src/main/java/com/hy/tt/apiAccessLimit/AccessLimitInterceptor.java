package com.hy.tt.apiAccessLimit;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * @auther thy
 * @date 2019/12/6
 */
@Component
public class AccessLimitInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(handler instanceof HandlerMethod){
            HandlerMethod hm = (HandlerMethod) handler;
            AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
            if(accessLimit == null){
                return true;
            }
            int seconds = accessLimit.seconds();
            int maxCount = accessLimit.maxCount();
            boolean b = accessLimit.needLogin();
            String requestURI = request.getRequestURI();
            if(b){
                requestURI = requestURI + "1";
            }

            //从redis中获取用户访问的次数
//            AccessKey ak = AccessKey.withExpire(seconds);
//            Integer count = redisService.get(ak,requestURI,Integer.class);
//            if(count == null){
//                //第一次访问
//                redisService.set(ak,key,1);
//            }else if(count < maxCount){
//                //加1
//                redisService.incr(ak,key);
//            }else{
//                //超出访问次数
//                render(response,""); //这里的CodeMsg是一个返回参数
//                return false;
//            }
        }

        return true;
    }


    private void render(HttpServletResponse response, String cm)throws Exception {
        response.setContentType("application/json;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        String str  = JSON.toJSONString(cm);
        out.write(str.getBytes("UTF-8"));
        out.flush();
        out.close();
    }

}
