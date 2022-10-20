package org.example.game;

import lombok.Getter;
@Getter
public enum FieldCoordinate {
    A('A'),
    B('B'),
    C('C'),
    D('D'),
    E('E');

    public final Character character;
    FieldCoordinate(Character i) {
        this.character = i;
    }
}
