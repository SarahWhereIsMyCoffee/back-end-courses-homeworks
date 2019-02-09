package it.sevenbits.formatter.formatter.statemachine;

import java.util.Objects;

/**
 * This class presents a states during the format() method in FormatterSM class.
 */
public class FormatterState {
    private final String currentState;

    /**
     * Constructor of FormatterState class.
     * Here we declare a name of state.
     *
     * @param currentState String name of state.
     */
    public FormatterState(final String currentState) {
        this.currentState = currentState;
    }

    /**
     * Method for calling of name of state.
     *
     * @return String name of the state
     */
    public String toString() {
        return currentState;
    }

    /**
     * Overriding of equals() method.
     * It checks is an passed object equals our instance.
     *
     * @param o Passed object for equals checking
     * @return Boolean value - result of checking.
     */
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

    /**
     * Overriding of hashCode() method
     *
     * @return Int hashCode of the instance.
     */
    @Override
    public int hashCode() {
        return Objects.hash(currentState);
    }

}
