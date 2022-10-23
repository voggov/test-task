package org.example.game;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class Field implements Serializable {
    private String playerName;
    private String messageFromServer = "Ваш ход:";

    private String step;
    private String field;

    public Field(String field) {
        this.field = field;
    }
}
