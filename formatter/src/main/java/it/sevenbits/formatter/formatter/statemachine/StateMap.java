package it.sevenbits.formatter.formatter.statemachine;

import java.util.HashMap;
import java.util.Map;

/**
 * StateMap - class for the transition from one state to other
 */
public class StateMap {
    private Map<String, FormatterState> formatterStateMap;

    private static final String OPENING_CURLY_BRACKET_LEXEME_NAME = "LEXEME_OPENING_CURLY_BRACKET";
    private static final String CLOSING_CURLY_BRACKET_LEXEME_NAME = "LEXEME_CLOSING_CURLY_BRACKET";
    private static final String SEMICOLON_LEXEME_NAME = "LEXEME_SEMICOLON";
    private static final String SPACE_LEXEME_NAME = "LEXEME_SPACE";
    private static final String NEW_LINE_LEXEME_NAME = "LEXEME_NEW_LINE";
    private static final String LINE_COMMENT_LEXEME_NAME = "LEXEME_LINE_COMMENT_STATE";
    private static final String BLOCK_COMMENT_LEXEME_NAME = "LEXEME_BLOCK_COMMENT_STATE";

    private static final FormatterState START_FORMATTER_STATE = new FormatterState("START_STATE");
    private static final FormatterState OPENING_CURLY_BRACKET_FORMATTER_STATE = new FormatterState("OPENING_CURLY_BRACKET_STATE");
    private static final FormatterState CLOSING_CURLY_BRACKET_FORMATTER_STATE = new FormatterState("CLOSING_CURLY_BRACKET_STATE");
    private static final FormatterState SEMICOLON_FORMATTER_STATE = new FormatterState("SEMICOLON_STATE");
    private static final FormatterState SPACE_FORMATTER_STATE = new FormatterState("SPACE_STATE");
    private static final FormatterState NEW_LINE_FORMATTER_STATE = new FormatterState("NEW_LINE_STATE");
    private static final FormatterState LINE_COMMENT_FORMATTER_STATE = new FormatterState("LINE_COMMENT_STATE");
    private static final FormatterState BLOCK_COMMENT_FORMATTER_STATE = new FormatterState("BLOCK_COMMENT_STATE");
    private static final FormatterState DEFAULT_LEXEME_FORMATTER_STATE = new FormatterState("DEFAULT_LEXEME_STATE");

    /**
     * Constructor for the StateMap class
     * Here we declare formatter states and HashMap, where states are stored.
     */
    public StateMap() {
        formatterStateMap = new HashMap<>();

        formatterStateMap.put(OPENING_CURLY_BRACKET_LEXEME_NAME, OPENING_CURLY_BRACKET_FORMATTER_STATE);
        formatterStateMap.put(CLOSING_CURLY_BRACKET_LEXEME_NAME, CLOSING_CURLY_BRACKET_FORMATTER_STATE);
        formatterStateMap.put(SEMICOLON_LEXEME_NAME, SEMICOLON_FORMATTER_STATE);
        formatterStateMap.put(SPACE_LEXEME_NAME, SPACE_FORMATTER_STATE);
        formatterStateMap.put(NEW_LINE_LEXEME_NAME, NEW_LINE_FORMATTER_STATE);
        formatterStateMap.put(LINE_COMMENT_LEXEME_NAME, LINE_COMMENT_FORMATTER_STATE);
        formatterStateMap.put(BLOCK_COMMENT_LEXEME_NAME, BLOCK_COMMENT_FORMATTER_STATE);
    }

    /**
     * This method implements transferring of new formatter state
     *
     * @param tokenName String name of token we've got
     * @return FormatterState instance
     */
    public FormatterState getNextState(final String tokenName) {
        return formatterStateMap.getOrDefault(tokenName, DEFAULT_LEXEME_FORMATTER_STATE);
    }

    /**
     * This method implements transferring of start state
     *
     * @return FormatterState instance
     */
    public FormatterState getStartFormatterState() {
        return START_FORMATTER_STATE;
    }
}
