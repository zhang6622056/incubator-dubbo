package com.nero.dubbo.netty;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientBootstrapPri {


    public static void main(String[] args) throws UnknownHostException {

        ExecutorService bossPool = Executors.newCachedThreadPool();
        ExecutorService workerPool = Executors.newCachedThreadPool();
        //-workercount = the maximum number of I/O worker threads
        ChannelFactory channelFactory = new NioClientSocketChannelFactory(bossPool, workerPool, 10);






        ClientBootstrap clientBootstrap = new ClientBootstrap(channelFactory);
        InetSocketAddress remote = new InetSocketAddress(Inet4Address.getLocalHost(),10025);
        InetSocketAddress local = new InetSocketAddress(Inet4Address.getLocalHost(),10000);
        ChannelFuture channelFuture = clientBootstrap.connect(remote,local);
    }




}
