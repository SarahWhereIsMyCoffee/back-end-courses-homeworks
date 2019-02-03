package it.sevenbits.formatter.formatter.statemachine;

public class FormatterStateTransition {

    private final FormatterStateMap stateMap;

    public FormatterStateTransition() {
        this.stateMap = new FormatterStateMap();
    }

    public FormatterState nextState(FormatterState formatterState, String tokenName) {
        return stateMap.getNextState(formatterState, tokenName);
    }

    public FormatterState getStartState() {
        return this.stateMap.getStartState();
    }
}

