package it.sevenbits.formatter.lexer;

import it.sevenbits.formatter.formatter.statemachine.FormatterState;

import java.util.Objects;

public class LexerState {
    private final String currentState;

    public LexerState(final String currentState) {
        this.currentState = currentState;
    }

    public String toString() {
        return currentState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LexerState state = (LexerState) o;
        return Objects.equals(currentState, state.currentState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentState);
    }
}
