package org.example.startserver.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.example.game.Field;
import org.example.game.GameField;
import org.example.game.Player;

import java.util.ArrayList;
import java.util.List;

public class ServerTestHandler extends ChannelInboundHandlerAdapter {

    private static GameField gameField = new GameField();
    private static List<Channel> channels = new ArrayList<>();
    private static List<Player> players = new ArrayList<>();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("connect");
        if (channels.size() > 2) {
            System.out.println("Игровая комната занята(");
            ctx.channel().close();
        } else {
            if (players.isEmpty()) {
                players.add(new Player('x', ctx.channel()));
            } else {
                players.add(new Player('o', ctx.channel()));

            }
            channels.add(ctx.channel());
            if (channels.size() == 2) {
                for (var i : players) {
                    if (i.getSymbol().equals('x')) {
                        Field clientField = new Field(gameField.convertCharFieldToString());
                        i.getChannel().writeAndFlush(clientField);
                    }
                }
            }
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Field field = (Field) msg;
        for (var i : players) {
            if (i.getChannel().equals(ctx.channel())) {
                gameField.setSymbol(field.getStep(), i.getSymbol());
                field.setField(gameField.convertCharFieldToString());
                for (var k : players){
                    if (!k.getChannel().equals(ctx.channel())) {
                        k.getChannel().writeAndFlush(field);
                    }
                }

            }
        }


        /*Message message = (Message) msg;
        System.out.println(message);

        message.setField("Huesosina");
        ctx.writeAndFlush(message).addListener(ChannelFutureListener.CLOSE);*/

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.channel().close();
    }
}
