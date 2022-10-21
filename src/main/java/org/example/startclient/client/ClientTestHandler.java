package org.example.startclient.client;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.example.game.Field;
import org.example.game.GameField;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class ClientTestHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ChannelFuture future = ctx.channel().closeFuture();
        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                System.out.println("Вы отключены");
            }
        });
        System.out.println("Вы подключились к игре:");
        /* String  name = */
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Field field = (Field) msg;
        System.out.println(field.getMessageFromServer());
        GameField gameField = new GameField(field.getField());
        gameField.printField();
/*        System.out.println("Ваш ход:");*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String step = reader.readLine();
        field.setStep(step);
        ctx.channel().writeAndFlush(field);
//        Message message = (Message) msg;
//        System.out.println(message.getField());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
