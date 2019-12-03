package com.hy.tt.netty.rpc.provider;

import com.hy.tt.netty.rpc.publicInterface.HelloServiceImpl;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.jboss.netty.bootstrap.ClientBootstrap;

/**
 * @auther thy
 * @date 2019/11/29
 */
public class HelloServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//       if(msg.toString().startsWith(ClientBootstrap.providerName)){
//           String result = new HelloServiceImpl()
//                   .hello(msg.toString().substring(msg.toString().lastIndexOf("#") + 1));
//           ctx.writeAndFlush(result);
//       }
    }
}
