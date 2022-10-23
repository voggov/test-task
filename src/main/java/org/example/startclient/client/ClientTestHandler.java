package org.example.startclient.client;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.example.game.Field;
import org.example.game.GameField;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ClientTestHandler extends ChannelInboundHandlerAdapter {
    private String playerName;


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ChannelFuture future = ctx.channel().closeFuture();
        future.addListener((ChannelFutureListener) future1 -> System.out.println("Вы отключены"));
        System.out.println("Вы подключились к игре:\n" +
                "Введите имя:");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        playerName = bf.readLine();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Field field = (Field) msg;
        field.setPlayerName(playerName);
        System.out.println(field.getMessageFromServer());
        if (field.getField() == null) {
            return;
        }
        GameField gameField = new GameField(field.getField());
        gameField.printField();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String step = reader.readLine();
        field.setStep(step);
        ctx.channel().writeAndFlush(field);
        System.out.println("Ожидайте:");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
