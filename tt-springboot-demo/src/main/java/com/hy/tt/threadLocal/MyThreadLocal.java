package com.hy.tt.threadLocal;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @auther thy
 * @date 2019/10/24
 */
public class MyThreadLocal<T> {

    private ConcurrentHashMap<Long,T> hashMap = new ConcurrentHashMap<>();

    public void set(T value){
        hashMap.put(Thread.currentThread().getId(),value);
    }

    public T get(){
        return hashMap.get(Thread.currentThread().getId());
    }
}
