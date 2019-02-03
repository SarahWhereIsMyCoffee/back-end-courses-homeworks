package it.sevenbits.formatter.formatter.statemachine;

import java.util.HashMap;
import java.util.Map;

public class FormatterStateMap {
    private String LEXEME_OPENING_CURLY_BRACKET = "LEXEME_OPENING_CURLY_BRACKET";
    private String LEXEME_CLOSING_CURLY_BRACKET = "LEXEME_CLOSING_CURLY_BRACKET";
    private String LEXEME_SEMICOLON = "LEXEME_SEMICOLON";
    private String LEXEME_SPACE = "LEXEME_SPACE";
    private String LEXEME_NEW_LINE = "LEXEME_NEW_LINE";
    private String LEXEME_SLASH = "LEXEME_SLASH";
    private String LEXEME_DEFAULT = "LEXEME_DEFAULT";

    private FormatterState startState;
    private FormatterState writeDefaultState;
    private FormatterState writeWithSpaceBeforeState;
    private FormatterState writeWithNewLineAfterState;
    private FormatterState writeWithNewLineBeforeState;
    private FormatterState writeWithSpaceBeforeAndNewLineAfterState;
    private FormatterState ignoreState;
    private FormatterState spaceIgnoreState;
    private FormatterState newLineIgnoreState;
    private Map<Pair<FormatterState, String>, FormatterState> formatterStateMap;

    public FormatterStateMap() {
        formatterStateMap = new HashMap<>();
        startState = new FormatterState("START");
        writeDefaultState = new FormatterState("WRITE_DEFAULT");
        writeWithNewLineAfterState = new FormatterState("WRITE_WITH_NEW_LINE_AFTER");
        writeWithNewLineBeforeState = new FormatterState("WRITE_WITH_NEW_LINE_BEFORE");
        writeWithSpaceBeforeState = new FormatterState("WRITE_WITH_SPACE_BEFORE");
        writeWithSpaceBeforeAndNewLineAfterState = new FormatterState("WRITE_WITH_SPACE_BEFORE_AND_NEW_LINE_AFTER");
        ignoreState = new FormatterState("IGNORE_STATE");
        spaceIgnoreState = new FormatterState("SPACE_IGNORE_STATE");
        newLineIgnoreState = new FormatterState("NEW_LINE_IGNORE_STATE");

        formatterStateMap.put(new Pair<>(startState, LEXEME_SEMICOLON), writeWithNewLineAfterState);
        formatterStateMap.put(new Pair<>(startState, LEXEME_CLOSING_CURLY_BRACKET), writeDefaultState);
        formatterStateMap.put(new Pair<>(startState, LEXEME_OPENING_CURLY_BRACKET), writeWithNewLineAfterState);
        formatterStateMap.put(new Pair<>(startState, LEXEME_SLASH), writeDefaultState);
        formatterStateMap.put(new Pair<>(startState, LEXEME_DEFAULT), writeDefaultState);

        formatterStateMap.put(new Pair<>(writeDefaultState, LEXEME_SEMICOLON), writeWithNewLineAfterState);
        formatterStateMap.put(new Pair<>(writeDefaultState, LEXEME_SLASH), writeWithSpaceBeforeState);
        formatterStateMap.put(new Pair<>(writeDefaultState, LEXEME_OPENING_CURLY_BRACKET), writeWithSpaceBeforeAndNewLineAfterState);
        formatterStateMap.put(new Pair<>(writeDefaultState, LEXEME_CLOSING_CURLY_BRACKET), writeWithNewLineBeforeState);
        formatterStateMap.put(new Pair<>(writeDefaultState, LEXEME_DEFAULT), writeWithSpaceBeforeState);
        formatterStateMap.put(new Pair<>(writeDefaultState, LEXEME_SPACE), spaceIgnoreState);

        formatterStateMap.put(new Pair<>(writeWithNewLineAfterState, LEXEME_SEMICOLON), writeWithNewLineAfterState);
        formatterStateMap.put(new Pair<>(writeWithNewLineAfterState, LEXEME_SLASH), writeWithSpaceBeforeState);
        formatterStateMap.put(new Pair<>(writeWithNewLineAfterState, LEXEME_OPENING_CURLY_BRACKET), writeWithNewLineAfterState);
        formatterStateMap.put(new Pair<>(writeWithNewLineAfterState, LEXEME_CLOSING_CURLY_BRACKET), writeDefaultState);
        formatterStateMap.put(new Pair<>(writeWithNewLineAfterState, LEXEME_DEFAULT), writeDefaultState);
        formatterStateMap.put(new Pair<>(writeWithNewLineAfterState, LEXEME_SPACE), ignoreState);

        formatterStateMap.put(new Pair<>(writeWithSpaceBeforeState, LEXEME_SEMICOLON), writeWithNewLineAfterState);
        formatterStateMap.put(new Pair<>(writeWithSpaceBeforeState, LEXEME_SLASH), writeWithSpaceBeforeState);
        formatterStateMap.put(new Pair<>(writeWithSpaceBeforeState, LEXEME_OPENING_CURLY_BRACKET), writeWithSpaceBeforeAndNewLineAfterState);
        formatterStateMap.put(new Pair<>(writeWithSpaceBeforeState, LEXEME_CLOSING_CURLY_BRACKET), writeWithSpaceBeforeState);
        formatterStateMap.put(new Pair<>(writeWithSpaceBeforeState, LEXEME_DEFAULT), writeWithSpaceBeforeState);
        formatterStateMap.put(new Pair<>(writeWithSpaceBeforeState, LEXEME_SPACE), spaceIgnoreState);

        formatterStateMap.put(new Pair<>(writeWithSpaceBeforeAndNewLineAfterState, LEXEME_SPACE), spaceIgnoreState);
        formatterStateMap.put(new Pair<>(writeWithSpaceBeforeAndNewLineAfterState, LEXEME_DEFAULT), writeDefaultState);

        formatterStateMap.put(new Pair<>(writeWithNewLineBeforeState, LEXEME_DEFAULT), writeDefaultState);
        formatterStateMap.put(new Pair<>(writeWithNewLineBeforeState, LEXEME_CLOSING_CURLY_BRACKET), writeWithNewLineBeforeState);

        formatterStateMap.put(new Pair<>(spaceIgnoreState, LEXEME_DEFAULT), writeWithSpaceBeforeState);
        formatterStateMap.put(new Pair<>(spaceIgnoreState, LEXEME_SEMICOLON), writeWithNewLineAfterState);
        formatterStateMap.put(new Pair<>(spaceIgnoreState, LEXEME_CLOSING_CURLY_BRACKET), writeWithNewLineBeforeState);

        formatterStateMap.put(new Pair<>(ignoreState, LEXEME_SEMICOLON), writeWithNewLineAfterState);
        formatterStateMap.put(new Pair<>(ignoreState, LEXEME_CLOSING_CURLY_BRACKET), writeDefaultState);
        formatterStateMap.put(new Pair<>(ignoreState, LEXEME_OPENING_CURLY_BRACKET), writeWithNewLineAfterState);
        formatterStateMap.put(new Pair<>(ignoreState, LEXEME_SLASH), writeDefaultState);
        formatterStateMap.put(new Pair<>(ignoreState, LEXEME_DEFAULT), writeDefaultState);
    }

    public FormatterState getNextState(FormatterState formatterState, String tokenName) {
        System.out.println(formatterState + ":" + tokenName);
        return formatterStateMap.getOrDefault(new Pair<>(formatterState, tokenName), ignoreState);
    }

    public FormatterState getStartState() {
        return startState;
    }
}
