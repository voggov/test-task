package org.example.startclient;

import io.netty.channel.socket.SocketChannel;
import org.example.startclient.client.ClientConnection;

import java.io.IOException;

public class Main {
    public static SocketChannel channel;

    public static void main(String[] args) throws InterruptedException, IOException {
        new ClientConnection().run();


        /*//String host = args[0];
        //int port = Integer.parseInt(args[1]);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap(); // (1)
            b.group(workerGroup); // (2)
            b.channel(NioSocketChannel.class); // (3)
            b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                public void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new StringDecoder(), new StringEncoder(), new ClientHandler());
                    channel = ch;
                }
            });
            ChannelFuture f = b.connect("localhost", 8081).sync(); // (5)
            // Wait until the connection is closed.
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }*/
    }

}