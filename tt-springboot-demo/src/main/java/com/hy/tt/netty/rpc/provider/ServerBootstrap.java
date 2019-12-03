package com.hy.tt.netty.rpc.provider;

/**
 * @auther thy
 * @date 2019/11/29
 */
public class ServerBootstrap {
    public static void main(String[] args) {
        NettyServer.startServer("localhost", 8088);
    }
}
