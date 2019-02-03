package it.sevenbits.formatter.lexer.statemachine;

import it.sevenbits.formatter.lexer.LexerState;

public class LexerStateTransition {

    private final LexerStateMap stateMap;

    public LexerStateTransition() {
        this.stateMap = new LexerStateMap();
    }

    public LexerState nextState(Character currentSymbol) {
        return stateMap.getNextState(currentSymbol);
    }
}
