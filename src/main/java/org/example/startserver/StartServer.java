package org.example.startserver;

import org.example.startserver.server.ServerApplication;

public class StartServer {
    public static void main(String[] args) throws InterruptedException {
        int port = 8081;
        new ServerApplication(port).run();

    }
}
