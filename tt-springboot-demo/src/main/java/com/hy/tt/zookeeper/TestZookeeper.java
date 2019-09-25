package com.hy.tt.zookeeper;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

/**
 * @auther thy
 * @date 2019/9/24
 */
public class TestZookeeper  implements Watcher {

    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws Exception{
        ZooKeeper zooKeeper = new ZooKeeper("127.0.0.1:2181", 5000, new TestZookeeper());
        countDownLatch.await();

        // 同步创建临时节点
        String ephemeralPath = zooKeeper.create("/zk-test-create-ephemeral-", "123".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("同步创临时建节点成功：" + ephemeralPath);

        // 同步创建临时顺序节点
        String sequentialPath = zooKeeper.create("/zk-test-create-sequential-", "456".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println("同步创建临时顺序节点成功：" + sequentialPath);

        // 异步创建临时节点
        zooKeeper.create("/zk-test-create-async-ephemeral-", "abc".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL, new MyStringCallBack(), "我是传递内容");

        // 异步创建临时顺序节点
        zooKeeper.create("/zk-test-create-async-sequential-","def".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL,new MyStringCallBack(),"我是传递内容");

        Thread.sleep(10000); // 验证等待回调结果使用，可根据实际情况自行调整


   
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
            countDownLatch.countDown();
        }
    }

    static class MyStringCallBack implements AsyncCallback.StringCallback {

        public void processResult(int rc, String path, Object ctx, String name) {
            System.out.println("异步创建回调结果：状态：" + rc +"；创建路径：" +
                    path + "；传递信息：" + ctx + "；实际节点名称：" + name);
        }
    }

}
