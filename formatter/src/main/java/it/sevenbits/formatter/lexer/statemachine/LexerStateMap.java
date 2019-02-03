package it.sevenbits.formatter.lexer.statemachine;

import it.sevenbits.formatter.lexer.LexerState;

import java.util.HashMap;
import java.util.Map;

public class LexerStateMap {
    private Map<Character, LexerState> lexerStateMap;
    private Character SYMBOL_OPENING_BRACKET = '{';
    private Character SYMBOL_CLOSING_BRACKET = '}';
    private Character SYMBOL_SEMICOLON = ';';
    private Character SYMBOL_SPACE = ' ';
    private Character SYMBOL_NEW_LINE = '\n';
    private Character SYMBOL_SLASH = '/';

    public LexerStateMap() {
        lexerStateMap = new HashMap<>();

        lexerStateMap.put(SYMBOL_CLOSING_BRACKET, new LexerState("CLOSING_CURLY_BRACKET_STATE"));
        lexerStateMap.put(SYMBOL_OPENING_BRACKET, new LexerState("OPENING_CURLY_BRACKET_STATE"));
        lexerStateMap.put(SYMBOL_SEMICOLON, new LexerState("SEMICOLON_STATE"));
        lexerStateMap.put(SYMBOL_SPACE, new LexerState("SPACE_STATE"));
        lexerStateMap.put(SYMBOL_NEW_LINE, new LexerState("NEW_LINE_STATE"));
        lexerStateMap.put(SYMBOL_SLASH, new LexerState("SLASH_STATE"));
    }

    public LexerState getNextState(Character currentSymbol) {
        return lexerStateMap.getOrDefault(currentSymbol, new LexerState("DEFAULT_STATE"));
    }
}
