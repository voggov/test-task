package org.example.game;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Field implements Serializable {
    private static Integer moveNumber = 0;

    private String messageFromServer;

    private String step;
    private String field;

    public Field(String field) {
        this.field = field;
    }
}
