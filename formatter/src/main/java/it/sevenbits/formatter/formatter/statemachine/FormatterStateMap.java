package it.sevenbits.formatter.formatter.statemachine;

import java.util.HashMap;
import java.util.Map;

/**
 * FormatterStateMap - class for the transition from one state to other
 */
public class FormatterStateMap {
    private Map<String, FormatterState> formatterStateMap;

    private static final String OPENING_CURLY_BRACKET_LEXEME_NAME = "LEXEME_OPENING_CURLY_BRACKET";
    private static final String CLOSING_CURLY_BRACKET_LEXEME_NAME = "LEXEME_CLOSING_CURLY_BRACKET";
    private static final String SEMICOLON_LEXEME_NAME = "LEXEME_SEMICOLON";
    private static final String SPACE_LEXEME_NAME = "LEXEME_SPACE";
    private static final String NEW_LINE_LEXEME_NAME = "LEXEME_NEW_LINE";
    private static final String LINE_COMMENT_LEXEME_NAME = "LEXEME_LINE_COMMENT_STATE";
    private static final String BLOCK_COMMENT_LEXEME_NAME = "LEXEME_BLOCK_COMMENT_STATE";
    private static final String DEFAULT_LEXEME_NAME = "LEXEME_DEFAULT";

    private FormatterState START_FORMATTER_STATE;
    private FormatterState OPENING_CURLY_BRACKET_FORMATTER_STATE;
    private FormatterState CLOSING_CURLY_BRACKET_FORMATTER_STATE;
    private FormatterState SEMICOLON_FORMATTER_STATE;
    private FormatterState SPACE_FORMATTER_STATE;
    private FormatterState NEW_LINE_FORMATTER_STATE;
    private FormatterState LINE_COMMENT_FORMATTER_STATE;
    private FormatterState BLOCK_COMMENT_FORMATTER_STATE;
    private FormatterState DEFAULT_LEXEME_FORMATTER_STATE;

    /**
     * Constructor for the FormatterStateMap class
     * Here we declare formatter states and HashMap, where states are stored.
     */
    public FormatterStateMap() {
        formatterStateMap = new HashMap<>();

        START_FORMATTER_STATE = new FormatterState("START_STATE");
        OPENING_CURLY_BRACKET_FORMATTER_STATE = new FormatterState("OPENING_CURLY_BRACKET_STATE");
        CLOSING_CURLY_BRACKET_FORMATTER_STATE = new FormatterState("CLOSING_CURLY_BRACKET_STATE");
        SEMICOLON_FORMATTER_STATE = new FormatterState("SEMICOLON_STATE");
        SPACE_FORMATTER_STATE = new FormatterState("SPACE_STATE");
        NEW_LINE_FORMATTER_STATE = new FormatterState("NEW_LINE_STATE");
        LINE_COMMENT_FORMATTER_STATE = new FormatterState("LINE_COMMENT_STATE");
        BLOCK_COMMENT_FORMATTER_STATE = new FormatterState("BLOCK_COMMENT_STATE");
        DEFAULT_LEXEME_FORMATTER_STATE = new FormatterState("DEFAULT_LEXEME_STATE");

        formatterStateMap.put(OPENING_CURLY_BRACKET_LEXEME_NAME, OPENING_CURLY_BRACKET_FORMATTER_STATE);
        formatterStateMap.put(CLOSING_CURLY_BRACKET_LEXEME_NAME, CLOSING_CURLY_BRACKET_FORMATTER_STATE);
        formatterStateMap.put(SEMICOLON_LEXEME_NAME, SEMICOLON_FORMATTER_STATE);
        formatterStateMap.put(SPACE_LEXEME_NAME, SPACE_FORMATTER_STATE);
        formatterStateMap.put(NEW_LINE_LEXEME_NAME, NEW_LINE_FORMATTER_STATE);
        formatterStateMap.put(LINE_COMMENT_LEXEME_NAME, LINE_COMMENT_FORMATTER_STATE);
        formatterStateMap.put(BLOCK_COMMENT_LEXEME_NAME, BLOCK_COMMENT_FORMATTER_STATE);
    }

    public FormatterState getNextState(String tokenName) {
        return formatterStateMap.getOrDefault(tokenName, DEFAULT_LEXEME_FORMATTER_STATE);
    }

    /**
     *
     * @return
     */
    public FormatterState getStartFormatterState() {
        return START_FORMATTER_STATE;
    }
}
