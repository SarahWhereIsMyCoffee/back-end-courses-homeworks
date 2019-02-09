package it.sevenbits.formatter.lexer.Token;

import it.sevenbits.formatter.lexer.statemachine.State;
import java.util.HashMap;
import java.util.Map;

/**
 * TokenBuilder is a class, with which tokens are created
 */
public class TokenBuilder {
    private StringBuilder tokenLexeme;
    private String tokenName;

    private Map<State, String> statesNameMap;
    private static final State OPENING_CURLY_BRACKET_STATE = new State("OPENING_CURLY_BRACKET_STATE");
    private static final State CLOSING_CURLY_BRACKET_STATE = new State("CLOSING_CURLY_BRACKET_STATE");
    private static final State SEMICOLON_STATE = new State("SEMICOLON_STATE");
    private static final State SPACE_STATE = new State("SPACE_STATE");
    private static final State NEW_LINE_STATE = new State("NEW_LINE_STATE");
    private static final State LINE_COMMENT_STATE = new State("LINE_COMMENT_STATE");
    private static final State BLOCK_COMMENT_STATE = new State("BLOCK_COMMENT_STATE");
    private static final State DEFAULT_STATE = new State("DEFAULT_STATE");

    private static final String OPENING_CURLY_BRACKET_LEXEME_NAME = "LEXEME_OPENING_CURLY_BRACKET";
    private static final String CLOSING_CURLY_BRACKET_LEXEME_NAME = "LEXEME_CLOSING_CURLY_BRACKET";
    private static final String SEMICOLON_LEXEME_NAME = "LEXEME_SEMICOLON";
    private static final String SPACE_LEXEME_NAME = "LEXEME_SPACE";
    private static final String NEW_LINE_LEXEME_NAME = "LEXEME_NEW_LINE";
    private static final String LINE_COMMENT_LEXEME_NAME = "LEXEME_LINE_COMMENT_STATE";
    private static final String BLOCK_COMMENT_LEXEME_NAME = "LEXEME_BLOCK_COMMENT_STATE";
    private static final String DEFAULT_LEXEME_NAME = "LEXEME_DEFAULT";

    /**
     * Constructor of TokenBuilder class.
     * Here we declare HashMap, which allows to set a name to tokens: keys - Character, value - String
     */
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

    /**
     * This method appends given character to the token's lexeme.
     * @param character - Character variable, that we append to lexeme.
     */
    public void appendCharacterToLexeme(final Character character) {
        tokenLexeme.append(character);
    }

    /**
     * This method sets a name to the token.
     * The name is set depending on previous lexer state.
     *
     * @param lexerState - previous lexer state, which with we set the name to token
     */
    public void setTokenName(final State lexerState) {
        tokenName = statesNameMap.getOrDefault(lexerState, "LEXEME_DEFAULT");
    }

    /**
     * This method returns new token.
     * Lexeme makes during the program, name is set before returns.
     *
     * @param lexerState - given lexer state, that we transmit to the setTokenName method.
     * @return new IToken token.
     */
    public IToken getToken(final State lexerState) {
        setTokenName(lexerState);
        String currentLexeme = tokenLexeme.toString();
        tokenLexeme.setLength(0);

        return new Token(tokenName, currentLexeme);
    }
}
