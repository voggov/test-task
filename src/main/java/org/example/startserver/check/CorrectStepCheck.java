package org.example.startserver.check;

import org.example.game.GameField;
import org.example.game.Player;

public class CorrectStepCheck implements CheckRool {
    private String step;

    public CorrectStepCheck(String step) {
        this.step = step;
    }

    @Override
    public boolean check(GameField gameField, Player player) {
        if ((step.charAt(0) == 'A' || step.charAt(0) == 'B' || step.charAt(0) == 'C') &&
                (Character.getNumericValue(step.charAt(1) - 1) == 0
                        || Character.getNumericValue(step.charAt(1) - 1) == 1
                        || Character.getNumericValue(step.charAt(1) - 1) == 2)) {
            return true;
        } else return false;
    }

}
