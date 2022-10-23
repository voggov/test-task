package org.example.game;

import lombok.Getter;

import java.io.Serializable;


@Getter
public class GameField implements Serializable {
    private final int SIZE = 3;
    private Character[][] field = new Character[SIZE][SIZE];

    public GameField(String field) {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int k = 0; k < SIZE; k++) {
                this.field[i][k] = field.charAt(count);
                count++;
            }
        }
    }

    public GameField() {
        for (int i = 0; i < SIZE; i++) {
            for (int k = 0; k < SIZE; k++) {
                field[i][k] = '_';
            }
            System.out.println();
        }
    }

    public void convertStringFieldToChar(String field) {
        int count = 0;
        for (Character[] i : this.field) {
            for (Character k : i) {
                k = field.charAt(count);
                count++;
            }
        }
    }

    public String convertCharFieldToString() {
        String temp = "";
        for (var i : field) {
            for (var k : i) {
                temp += Character.toString(k);
            }
        }
        return temp;
    }

    public void setSymbol(String xy, Character symbol) {
        int x = 0;
        int y = 0;
        x = Character.getNumericValue(xy.charAt(1) - 1);
        switch (xy.charAt(0)) {
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
        field[x][y] = symbol;
    }

    public void printField() {
        System.out.println("  A B C");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int k = 0; k < SIZE; k++) {
                System.out.print(field[i][k] + " ");
            }
            System.out.println();
        }
    }


    public Character[][] getField() {
        return field;
    }
}
