package it.sevenbits.formatter.lexer.statemachine;

/**
 * This class is a wrapper for StateMap.
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
     * by calling .getNextState method of StateMap implementation.
     *
     * @param lexerState - State implementation transferred to .getNextState method.
     * @param currentSymbol -  Character implementation transferred to .getNextState method.
     * @return State implementation.
     */
    public State nextState(final State lexerState, final Character currentSymbol) {
        return stateMap.getNextState(lexerState, currentSymbol);
    }

    /**
     * This method calls for the start lexer state.
     *
     * @return State implementation.
     */
    public State startState() {
        return stateMap.getStartState();
    }
}
