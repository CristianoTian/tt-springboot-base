package com.hy.tt.redis.lock;

/**
 * @auther thy
 * @date 2019/10/12
 */
public interface DistributedLock {
    /**
     * 获取锁
     * @return
     */
    String acquire();

}
