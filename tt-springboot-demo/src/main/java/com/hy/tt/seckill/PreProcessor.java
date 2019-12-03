package com.hy.tt.seckill;


import org.springframework.http.HttpRequest;

/**
 * @auther thy
 * @date 2019/11/29
 */
public class PreProcessor {

    //商品是否剩余
    private static boolean reminds = true;

    private static void forbidden(){
        //Do something
    }

    public static  boolean checkReminds(){
        if(reminds){
            //检查是否有剩余,如果没有剩余 reminds = false
        }
        return reminds;
    }

    public static void preProcess(HttpRequest request){
        if(checkReminds()){
            // 一个并发的队列
            RequestQueue.queue.add(request);
        }else{
            // 如果已经没有商品了，则直接驳回请求即可.
            forbidden();
        }
    }
}
