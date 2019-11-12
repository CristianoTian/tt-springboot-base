package com.hy.tt.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @auther thy
 * @date 2019/11/12
 */
public class DiscardClient {

    static class MyThread implements Runnable{

        @Override
        public void run() {
            connect("127.0.0.1",8080);
        }

        public void connect(String host, int port){
            //配置客户端NIO 线程池
            NioEventLoopGroup group = new NioEventLoopGroup();
            try{
                Bootstrap b = new Bootstrap();
                b.group(group).channel(NioSocketChannel.class)
                        .option(ChannelOption.TCP_NODELAY,true)
                        .handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel ch) throws Exception {
                                ch.pipeline().addLast(new DiscardClientHandler());
                            }
                        });

                /**connect：发起异步连接操作，调用同步方法 sync 等待连接成功*/
                ChannelFuture channelFuture = b.connect(host, port).sync();
                System.out.println(Thread.currentThread().getName() + ",客户端发起异步连接..........");

                /**等待客户端链路关闭*/
                channelFuture.channel().closeFuture().sync();

            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                group.shutdownGracefully();
            }
        }
    }

    /**
     * 使用 3 个线程模拟三个客户端
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new MyThread()).start();
        }
    }

}
