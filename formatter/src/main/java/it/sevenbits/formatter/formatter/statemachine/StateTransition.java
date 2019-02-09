package it.sevenbits.formatter.formatter.statemachine;

/**
 * This class is a wrapper for StateMap class.
 */
public class StateTransition {

    private final StateMap stateMap;

    /**
     * Constructor of StateTransition class.
     * Here we declare a StateMap implementation.
     */
    public StateTransition() {
        this.stateMap = new StateMap();
    }

    /**
     * This method implementations transition for the new state
     * by calling getNextState() method of StateMap instance.
     * @param tokenName String name of current token
     * @return FormatterState instance
     */
    public FormatterState nextState(final String tokenName) {
        return stateMap.getNextState(tokenName);
    }

    /**
     * This method transferred a start formatter state
     * @return FormatterState instance
     */
    public FormatterState getStartState() {
        return this.stateMap.getStartFormatterState();
    }
}

