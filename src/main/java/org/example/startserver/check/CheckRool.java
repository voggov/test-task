package org.example.startserver.check;

import lombok.Getter;
import org.example.game.GameField;
import org.example.game.Player;

import java.util.List;

public interface CheckRool {

    boolean check(GameField gameField, Player player);
}
