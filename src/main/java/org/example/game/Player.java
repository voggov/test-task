package org.example.game;

import io.netty.channel.Channel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String name;
    private Character symbol;
    private Channel channel;

    public Player(Character symbol, Channel channel) {
        this.symbol = symbol;
        this.channel = channel;
    }

    public Player(String name, Character symbol, Channel channel) {
        this.name = name;
        this.symbol = symbol;
        this.channel = channel;
    }

    public Player(String name, Channel channel) {
        this.name = name;
        this.channel = channel;
    }

    public Player(String name) {
        this.name = name;
    }
}
