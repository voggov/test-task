package org.example.startserver.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.example.game.Field;
import org.example.game.GameField;
import org.example.game.Player;
import org.example.startserver.check.CheckClass;

import java.util.ArrayList;
import java.util.List;

public class ServerTestHandler extends ChannelInboundHandlerAdapter {

    private static final GameField gameField = new GameField();
    private static List<Channel> channels = new ArrayList<>();
    private static List<Player> players = new ArrayList<>();

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("connect");
        if (channels.size() >= 2) {
            Field message = new Field();
            message.setMessageFromServer("Игровая комната занята");
            System.out.println("Подключился 3 игрок");
            ctx.channel().writeAndFlush(message);
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
            CheckClass checkClass = new CheckClass(field.getStep(), gameField, i);
            if (i.getChannel().equals(ctx.channel())) {
                if (!checkClass.checkCorrectStep()) {
                    field.setMessageFromServer("Неккоректный ввод данных:\n Ваш ход:");
                    field.setField(gameField.convertCharFieldToString());
                    i.getChannel().writeAndFlush(field);
                    return;
                }
                if (!checkClass.checkTakeField()) {
                    field.setMessageFromServer("Выбранное поле уже занято:\n Ваш ход:");
                    field.setField(gameField.convertCharFieldToString());
                    i.getChannel().writeAndFlush(field);
                    return;
                }
                gameField.setSymbol(field.getStep(), i.getSymbol());
                field.setField(gameField.convertCharFieldToString());
                if (!checkClass.checkEndGame()) {
                    field.setMessageFromServer("Победил " + field.getPlayerName() + "(" + i.getSymbol() + ")!!!!");
                    players.forEach(player -> player.getChannel().writeAndFlush(field).channel().close());
                    return;
                }
                for (var k : players) {
                    if (!k.getChannel().equals(ctx.channel())) {
                        field.setMessageFromServer("Ваш ход:");
                        k.getChannel().writeAndFlush(field);
                    }
                }

            }
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.channel().close();
    }
}
