package it.sevenbits.formatter.lexer.statemachine;

public class LexerStateTransition {

    private final LexerStateMap stateMap;

    public LexerStateTransition() {
        this.stateMap = new LexerStateMap();
    }

    public LexerState nextState(LexerState lexerState, Character currentSymbol) {
        return stateMap.getNextState(lexerState, currentSymbol);
    }

    public LexerState startState() {
        return stateMap.getStartState();
    }
}
