package org.example.startserver.check;

import lombok.Getter;
import org.example.game.GameField;
import org.example.game.Player;
import org.example.startserver.exception.SetSymbolException;

@Getter
public class TakeFieldCheck implements CheckRool {
    private final String step;

    public TakeFieldCheck(String step) {
        this.step = step;
    }

    @Override
    public boolean check(GameField gameField, Player player) {
        try {
            if (gameField.getField()[stepCheck(step)[0]][stepCheck(step)[1]] == '_') {
                return true;
            } else throw new SetSymbolException("Выбранная ячейка уже занята", step);
        } catch (SetSymbolException exception) {
            System.err.println(exception.getMessage() + "\n" + exception.getStep());
            return false;
        }
    }

    public Integer[] stepCheck(String step) {
        int x;
        int y = 0;
        x = Character.getNumericValue(step.charAt(1) - 1);
        switch (step.charAt(0)) {
            case 'A':
                y = 0;
                break;
            case 'B':
                y = 1;
                break;
            case 'C':
                y = 2;
                break;
        }
        return new Integer[]{x, y};
    }
}
