package com.hy.tt.zookeeper;

import org.I0Itec.zkclient.ZkClient;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @auther thy
 * @date 2019/11/7
 */
public class SimpleDistributedLockMutex extends BaseDistributedLock  implements  DistributedLock{


    public SimpleDistributedLockMutex(ZkClient client, String path) {
        super(client, path,LOCK_NAME);
        this.basePath = path;
    }

    /**
     * 用于保存Zookeeper中实现分布式锁的节点,如名称为locker: /locker.
     * 该节点应该是持久节点,在该节点下面创建临时顺序节点来实现分布式锁
     */
    private String basePath;

    /**
     * 锁名称前缀,locker下创建的顺序节点例如都以lock-开头,这样便于过滤无关节点
     * 这样创建后的节点类似: lock-00000001 , lock-00000000002
     */
    private static final String LOCK_NAME = "lock-";

    /**用于保存某个客户端在locker下面创建成功的顺序节点，用于后续相关操作使用（如判断）*/
    private String  ourLockPath;

    /**
     * 用户获取锁资源,通过父类的获取锁方法来获取锁
     * @param time
     * @param unit
     * @return
     * @throws Exception
     */
    private boolean internalLock(long time, TimeUnit unit) throws  Exception{
        ourLockPath = attemptLock(time,unit);
        return ourLockPath != null;
    }



    @Override
    public void acquire() throws Exception {
        if(!internalLock(-1,null)){
            throw new IOException("连接丢失!在路径:" + basePath + "下不能获取锁");
        }
    }

    @Override
    public boolean acquire(long time, TimeUnit unit) throws Exception {
        return internalLock(time,unit);
    }

    @Override
    public void release() throws Exception {
        releaseLock(ourLockPath);
    }
}
