package it.sevenbits.formatter.lexer.Token;

import it.sevenbits.formatter.lexer.statemachine.LexerState;

import java.util.HashMap;
import java.util.Map;

public class TokenBuilder {
    private StringBuilder tokenLexeme;
    private String tokenName;

    private Map<LexerState, String> statesNameMap;
    private static final LexerState OPENING_CURLY_BRACKET_STATE = new LexerState("OPENING_CURLY_BRACKET_STATE");
    private static final LexerState CLOSING_CURLY_BRACKET_STATE = new LexerState("CLOSING_CURLY_BRACKET_STATE");
    private static final LexerState SEMICOLON_STATE = new LexerState("SEMICOLON_STATE");
    private static final LexerState SPACE_STATE = new LexerState("SPACE_STATE");
    private static final LexerState NEW_LINE_STATE = new LexerState("NEW_LINE_STATE");
    private static final LexerState LINE_COMMENT_STATE = new LexerState("LINE_COMMENT_STATE");
    private static final LexerState BLOCK_COMMENT_STATE = new LexerState("BLOCK_COMMENT_STATE");
    private static final LexerState DEFAULT_STATE = new LexerState("DEFAULT_STATE");

    private static final String OPENING_CURLY_BRACKET_LEXEME_NAME = "LEXEME_OPENING_CURLY_BRACKET";
    private static final String CLOSING_CURLY_BRACKET_LEXEME_NAME = "LEXEME_CLOSING_CURLY_BRACKET";
    private static final String SEMICOLON_LEXEME_NAME = "LEXEME_SEMICOLON";
    private static final String SPACE_LEXEME_NAME = "LEXEME_SPACE";
    private static final String NEW_LINE_LEXEME_NAME = "LEXEME_NEW_LINE";
    private static final String LINE_COMMENT_LEXEME_NAME = "LEXEME_LINE_COMMENT_STATE";
    private static final String BLOCK_COMMENT_LEXEME_NAME = "LEXEME_BLOCK_COMMENT_STATE";
    private static final String DEFAULT_LEXEME_NAME = "LEXEME_DEFAULT";


    public TokenBuilder() {
        statesNameMap = new HashMap<>();
        tokenLexeme = new StringBuilder();

        statesNameMap.put(OPENING_CURLY_BRACKET_STATE, OPENING_CURLY_BRACKET_LEXEME_NAME);
        statesNameMap.put(CLOSING_CURLY_BRACKET_STATE, CLOSING_CURLY_BRACKET_LEXEME_NAME);
        statesNameMap.put(SEMICOLON_STATE, SEMICOLON_LEXEME_NAME);
        statesNameMap.put(SPACE_STATE, SPACE_LEXEME_NAME);
        statesNameMap.put(NEW_LINE_STATE, NEW_LINE_LEXEME_NAME);
        statesNameMap.put(LINE_COMMENT_STATE, LINE_COMMENT_LEXEME_NAME);
        statesNameMap.put(BLOCK_COMMENT_STATE, BLOCK_COMMENT_LEXEME_NAME);
        statesNameMap.put(DEFAULT_STATE, DEFAULT_LEXEME_NAME);
    }

    public void appendCharacterToLexeme(Character character) {
        tokenLexeme.append(character);
    }

    public void setTokenName(LexerState lexerState) {
        tokenName = statesNameMap.getOrDefault(lexerState, "DEFAULT_STATE");
    }

    public IToken getToken(LexerState lexerState) {
        setTokenName(lexerState);
        String currentLexeme = tokenLexeme.toString();
        tokenLexeme.setLength(0);
        return new Token(tokenName, currentLexeme);
    }
}
