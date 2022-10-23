package org.example.startclient.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientConnection {

    public void run() throws IOException {
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap(); // (1)
            b.group(workerGroup); // (2)
            b.channel(NioSocketChannel.class); // (3)
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.handler(new ClientTestInit());
            //TODO не забудь вернуть сука b.handler(new ClientInit());
            Channel channel = b.connect("localhost", 8081).sync().channel();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            while (channel.isActive()) {
                channel.read();
            }
            /*ChannelFuture future = b.connect("localhost", 8081).sync();
            future.channel().closeFuture().sync();*/
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}

