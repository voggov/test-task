package org.example.startserver.check;

import org.example.game.GameField;
import org.example.game.Player;

public class EndGameCheck implements CheckRool {
    @Override
    public boolean check(GameField gameField, Player player) {
        return checkDiagonal(gameField.getField(), player) && checkHorizontal(gameField.getField(), player) && checkVertical(gameField.getField(), player);
    }

    public boolean checkDiagonal(Character[][] field, Player player) {
        return (field[0][0] != player.getSymbol() || field[1][1] != player.getSymbol() || field[2][2] != player.getSymbol()) &&
                (field[0][2] != player.getSymbol() || field[1][1] != player.getSymbol() || field[2][0] != player.getSymbol());
    }

    public boolean checkHorizontal(Character[][] field, Player player) {
        return (field[0][0] != player.getSymbol() || field[0][1] != player.getSymbol() || field[0][2] != player.getSymbol()) &&
                (field[1][0] != player.getSymbol() || field[1][1] != player.getSymbol() || field[1][2] != player.getSymbol()) &&
                (field[2][0] != player.getSymbol() || field[2][1] != player.getSymbol() || field[2][2] != player.getSymbol());    //player.getName() + "\"" + player.getSymbol() + "\": " + "Победил"
    }

    public boolean checkVertical(Character[][] field, Player player) {
        return (field[0][0] != player.getSymbol() || field[1][0] != player.getSymbol() || field[2][0] != player.getSymbol()) &&
                (field[0][1] != player.getSymbol() || field[1][1] != player.getSymbol() || field[1][2] != player.getSymbol()) &&
                (field[0][2] != player.getSymbol() || field[1][2] != player.getSymbol() || field[2][2] != player.getSymbol());

    }

}
