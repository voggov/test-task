package org.example.startclient;

import io.netty.channel.socket.SocketChannel;
import org.example.startclient.client.ClientConnection;

import java.io.IOException;

public class Main {
    public static SocketChannel channel;

    public static void main(String[] args) throws InterruptedException, IOException {
        new ClientConnection().run();
    }

}