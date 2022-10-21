package org.example.startserver.check;

import org.example.game.GameField;
import org.example.game.Player;

public class CheckClass {
    private String step;
    private GameField gameField;
    private Player player;

    public CheckClass(String step, GameField gameField, Player player) {
        this.step = step;
        this.gameField = gameField;
        this.player = player;
    }

    public boolean checkCorrectStep() {
        return new CorrectStepCheck(step).check(gameField, player);
    }
    public boolean checkEndGame() {
        EndGameCheck endGameCheck = new EndGameCheck();
        if (endGameCheck.checkVertical(gameField.getField(), player)
                && endGameCheck.checkHorizontal(gameField.getField(), player)
                && endGameCheck.checkDiagonal(gameField.getField(), player)){
            return true;
        }
        return false;
    }
    public boolean checkTakeField() {
        return new TakeFieldCheck(step).check(gameField, player);
    }
}
