package org.example.startserver.check;

import org.example.game.GameField;
import org.example.game.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EndGameCheck implements CheckRool {
    @Override
    public boolean check(GameField gameField, Player player) {
        if (checkDiagonal(gameField.getField(), player) && checkHorizontal(gameField.getField(), player) && checkVertical(gameField.getField(), player)){
            return true;
        }
        return false;
    }

    public boolean checkDiagonal(Character[][] field, Player player) {
        if ((field[0][0] == player.getSymbol() && field[1][1] == player.getSymbol() && field[2][2] == player.getSymbol()) ||
                (field[0][2] == player.getSymbol() && field[1][1] == player.getSymbol() && field[2][0] == player.getSymbol())
        ) {
            return false;
        }
        return true;
    }

    public boolean checkHorizontal(Character[][] field, Player player) {
        if ((field[0][0] == player.getSymbol() && field[0][1] == player.getSymbol() && field[0][2] == player.getSymbol()) ||
                (field[1][0] == player.getSymbol() && field[1][1] == player.getSymbol() && field[1][2] == player.getSymbol()) ||
                (field[2][0] == player.getSymbol() && field[2][1] == player.getSymbol() && field[2][2] == player.getSymbol())) {
            return false;    //player.getName() + "\"" + player.getSymbol() + "\": " + "Победил"
        }
        return true;
    }

    public boolean checkVertical(Character[][] field, Player player) {
        if ((field[0][0] == player.getSymbol() && field[1][0] == player.getSymbol() && field[2][0] == player.getSymbol()) ||
                (field[0][1] == player.getSymbol() && field[1][1] == player.getSymbol() && field[1][2] == player.getSymbol()) ||
                (field[0][2] == player.getSymbol() && field[1][2] == player.getSymbol() && field[2][2] == player.getSymbol())) {
            return false;
        }
        return true;

    }

}
