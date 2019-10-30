package com.nero.dubbo.netty;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerBootstrapPri {




    public static void main(String[] args) {
        ExecutorService bossPool = Executors.newCachedThreadPool();
        ExecutorService workerPool = Executors.newCachedThreadPool();
        //-workercount = the maximum number of I/O worker threads
        ChannelFactory channelFactory = new NioServerSocketChannelFactory(bossPool, workerPool, 10);
        ServerBootstrap bootstrap = new ServerBootstrap(channelFactory);


        //- 获取bind address&port,启动server
        InetSocketAddress inetSocketAddress = new InetSocketAddress(10025);


        //- 声明handler处理器
        SimpleChannelHandlerPri channelHandler = new SimpleChannelHandlerPri();


        //- 设置channel处理器
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                ChannelPipeline pipeline = Channels.pipeline();
                pipeline.addLast("handler",channelHandler);
                return pipeline;
            }
        });


        //- channel是做什么用的 ？
        Channel channel = bootstrap.bind(inetSocketAddress);
    }







}
