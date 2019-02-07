package it.sevenbits.formatter.formatter.statemachine;

import java.util.Objects;

public class FormatterState {
    private final String currentState;

    public FormatterState(final String currentState) {
        this.currentState = currentState;
    }

    public String toString() {
        return currentState;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FormatterState state = (FormatterState) o;
        return Objects.equals(currentState, state.currentState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentState);
    }

}
