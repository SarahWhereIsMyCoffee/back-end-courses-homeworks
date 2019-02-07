package it.sevenbits.formatter.lexer.statemachine;

import java.util.Objects;

/**
 * This class presents lexer state.
 */
public class State {
    private final String currentState;

    /**
     * Constructor of State class, where we set a name of state.
     *
     * @param currentState - String variable, name of state
     */
    public State(final String currentState) {
        this.currentState = currentState;
    }

    /**
     * Overriding of toString() method.
     *
     * @return String instance - name of lexer state.
     */
    public String toString() {
        return currentState;
    }

    /**
     * Override of equals() method.
     *
     * @param o - instance to check equality with.
     * @return Boolean value that presents result of checking.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        State state = (State) o;
        return Objects.equals(currentState, state.currentState);
    }


    /**
     * Override of hashCode() method.
     *
     * @return Integer value that presents hash code of State instance.
     */
    @Override
    public int hashCode() {
        return Objects.hash(currentState);
    }
}
