package org.example.startserver.exception;

import lombok.Getter;

@Getter
public class SetSymbolException extends Exception {

    private String step;

    public SetSymbolException(String message, String step) {
        super(message);
        this.step = step;
    }
}
