package it.sevenbits.formatter.lexer.statemachine;

import it.sevenbits.formatter.pair.Pair;

import java.util.HashMap;
import java.util.Map;

public class LexerStateMap {
    private Map<Pair<LexerState, Character>, LexerState> lexerStateMap;
    private Map<LexerState, LexerState> defaultStateMap;

    private static final Character SYMBOL_OPENING_CURLY_BRACKET = '{';
    private static final Character SYMBOL_CLOSING_CURLY_BRACKET = '}';
    private static final Character SYMBOL_SEMICOLON = ';';
    private static final Character SYMBOL_SPACE = ' ';
    private static final Character SYMBOL_NEW_LINE = '\n';
    private static final Character SYMBOL_SLASH = '/';
    private static final Character SYMBOL_STAR = '*';

    private static final LexerState OPENING_CURLY_BRACKET_STATE = new LexerState("OPENING_CURLY_BRACKET_STATE");
    private static final LexerState CLOSING_CURLY_BRACKET_STATE = new LexerState("CLOSING_CURLY_BRACKET_STATE");
    private static final LexerState SEMICOLON_STATE = new LexerState("SEMICOLON_STATE");
    private static final LexerState SPACE_STATE = new LexerState("SPACE_STATE");
    private static final LexerState NEW_LINE_STATE = new LexerState("NEW_LINE_STATE");
    private static final LexerState POTENTIONAL_COMMENT_STATE = new LexerState("POTENTIONAL_COMMENT_STATE");
    private static final LexerState LINE_COMMENT_STATE = new LexerState("LINE_COMMENT_STATE");
    private static final LexerState BLOCK_COMMENT_STATE = new LexerState("BLOCK_COMMENT_STATE");
    private static final LexerState POTENTIONAL_END_OF_BLOCK_COMMENT_STATE = new LexerState("POTENTIONAL_END_OF_BLOCK_COMMENT_STATE");
    private static final LexerState END_OF_LEXEME_STATE = new LexerState("END_OF_LEXEME_STATE");
    private static final LexerState DEFAULT_STATE = new LexerState("DEFAULT_STATE");


    public LexerStateMap() {
        lexerStateMap = new HashMap<>();
        defaultStateMap = new HashMap<>();


        defaultStateMap.put(OPENING_CURLY_BRACKET_STATE, END_OF_LEXEME_STATE);
        defaultStateMap.put(CLOSING_CURLY_BRACKET_STATE, END_OF_LEXEME_STATE);
        defaultStateMap.put(SEMICOLON_STATE, END_OF_LEXEME_STATE);
        defaultStateMap.put(SPACE_STATE, END_OF_LEXEME_STATE);
        defaultStateMap.put(NEW_LINE_STATE, END_OF_LEXEME_STATE);


        lexerStateMap.put(new Pair<>(POTENTIONAL_COMMENT_STATE, SYMBOL_OPENING_CURLY_BRACKET), END_OF_LEXEME_STATE);
        lexerStateMap.put(new Pair<>(POTENTIONAL_COMMENT_STATE, SYMBOL_CLOSING_CURLY_BRACKET), END_OF_LEXEME_STATE);
        lexerStateMap.put(new Pair<>(POTENTIONAL_COMMENT_STATE, SYMBOL_SEMICOLON), END_OF_LEXEME_STATE);
        lexerStateMap.put(new Pair<>(POTENTIONAL_COMMENT_STATE, SYMBOL_SPACE), END_OF_LEXEME_STATE);
        lexerStateMap.put(new Pair<>(POTENTIONAL_COMMENT_STATE, SYMBOL_NEW_LINE), END_OF_LEXEME_STATE);
        lexerStateMap.put(new Pair<>(POTENTIONAL_COMMENT_STATE, SYMBOL_SLASH), LINE_COMMENT_STATE);
        lexerStateMap.put(new Pair<>(POTENTIONAL_COMMENT_STATE, SYMBOL_STAR), BLOCK_COMMENT_STATE);

        lexerStateMap.put(new Pair<>(LINE_COMMENT_STATE, SYMBOL_OPENING_CURLY_BRACKET), LINE_COMMENT_STATE);
        lexerStateMap.put(new Pair<>(LINE_COMMENT_STATE, SYMBOL_CLOSING_CURLY_BRACKET), LINE_COMMENT_STATE);
        lexerStateMap.put(new Pair<>(LINE_COMMENT_STATE, SYMBOL_SEMICOLON), LINE_COMMENT_STATE);
        lexerStateMap.put(new Pair<>(LINE_COMMENT_STATE, SYMBOL_SPACE), LINE_COMMENT_STATE);
        lexerStateMap.put(new Pair<>(LINE_COMMENT_STATE, SYMBOL_NEW_LINE), END_OF_LEXEME_STATE);
        lexerStateMap.put(new Pair<>(LINE_COMMENT_STATE, SYMBOL_SLASH), LINE_COMMENT_STATE);
        lexerStateMap.put(new Pair<>(LINE_COMMENT_STATE, SYMBOL_STAR), LINE_COMMENT_STATE);

        lexerStateMap.put(new Pair<>(BLOCK_COMMENT_STATE, SYMBOL_OPENING_CURLY_BRACKET), BLOCK_COMMENT_STATE);
        lexerStateMap.put(new Pair<>(BLOCK_COMMENT_STATE, SYMBOL_CLOSING_CURLY_BRACKET), BLOCK_COMMENT_STATE);
        lexerStateMap.put(new Pair<>(BLOCK_COMMENT_STATE, SYMBOL_SEMICOLON), BLOCK_COMMENT_STATE);
        lexerStateMap.put(new Pair<>(BLOCK_COMMENT_STATE, SYMBOL_SPACE), BLOCK_COMMENT_STATE);
        lexerStateMap.put(new Pair<>(BLOCK_COMMENT_STATE, SYMBOL_NEW_LINE), BLOCK_COMMENT_STATE);
        lexerStateMap.put(new Pair<>(BLOCK_COMMENT_STATE, SYMBOL_SLASH), BLOCK_COMMENT_STATE);
        lexerStateMap.put(new Pair<>(BLOCK_COMMENT_STATE, SYMBOL_STAR), POTENTIONAL_END_OF_BLOCK_COMMENT_STATE);

        lexerStateMap.put(new Pair<>(POTENTIONAL_END_OF_BLOCK_COMMENT_STATE, SYMBOL_OPENING_CURLY_BRACKET), BLOCK_COMMENT_STATE);
        lexerStateMap.put(new Pair<>(POTENTIONAL_END_OF_BLOCK_COMMENT_STATE, SYMBOL_CLOSING_CURLY_BRACKET), BLOCK_COMMENT_STATE);
        lexerStateMap.put(new Pair<>(POTENTIONAL_END_OF_BLOCK_COMMENT_STATE, SYMBOL_SEMICOLON), BLOCK_COMMENT_STATE);
        lexerStateMap.put(new Pair<>(POTENTIONAL_END_OF_BLOCK_COMMENT_STATE, SYMBOL_SPACE), BLOCK_COMMENT_STATE);
        lexerStateMap.put(new Pair<>(POTENTIONAL_END_OF_BLOCK_COMMENT_STATE, SYMBOL_NEW_LINE), BLOCK_COMMENT_STATE);
        lexerStateMap.put(new Pair<>(POTENTIONAL_END_OF_BLOCK_COMMENT_STATE, SYMBOL_SLASH), END_OF_LEXEME_STATE);
        lexerStateMap.put(new Pair<>(POTENTIONAL_END_OF_BLOCK_COMMENT_STATE, SYMBOL_STAR), BLOCK_COMMENT_STATE);

        lexerStateMap.put(new Pair<>(END_OF_LEXEME_STATE, SYMBOL_OPENING_CURLY_BRACKET), OPENING_CURLY_BRACKET_STATE);
        lexerStateMap.put(new Pair<>(END_OF_LEXEME_STATE, SYMBOL_CLOSING_CURLY_BRACKET), CLOSING_CURLY_BRACKET_STATE);
        lexerStateMap.put(new Pair<>(END_OF_LEXEME_STATE, SYMBOL_SEMICOLON), SEMICOLON_STATE);
        lexerStateMap.put(new Pair<>(END_OF_LEXEME_STATE, SYMBOL_SPACE), SPACE_STATE);
        lexerStateMap.put(new Pair<>(END_OF_LEXEME_STATE, SYMBOL_NEW_LINE), NEW_LINE_STATE);
        lexerStateMap.put(new Pair<>(END_OF_LEXEME_STATE, SYMBOL_SLASH), POTENTIONAL_COMMENT_STATE);
        lexerStateMap.put(new Pair<>(END_OF_LEXEME_STATE, SYMBOL_STAR), DEFAULT_STATE);

        lexerStateMap.put(new Pair<>(DEFAULT_STATE, SYMBOL_OPENING_CURLY_BRACKET), END_OF_LEXEME_STATE);
        lexerStateMap.put(new Pair<>(DEFAULT_STATE, SYMBOL_CLOSING_CURLY_BRACKET), END_OF_LEXEME_STATE);
        lexerStateMap.put(new Pair<>(DEFAULT_STATE, SYMBOL_SEMICOLON), END_OF_LEXEME_STATE);
        lexerStateMap.put(new Pair<>(DEFAULT_STATE, SYMBOL_SPACE), END_OF_LEXEME_STATE);
        lexerStateMap.put(new Pair<>(DEFAULT_STATE, SYMBOL_NEW_LINE), END_OF_LEXEME_STATE);
        lexerStateMap.put(new Pair<>(DEFAULT_STATE, SYMBOL_SLASH), POTENTIONAL_COMMENT_STATE);
        lexerStateMap.put(new Pair<>(DEFAULT_STATE, SYMBOL_STAR), DEFAULT_STATE);
    }

    public LexerState getNextState(LexerState lexerState, Character character) {
        return lexerStateMap.getOrDefault(new Pair<>(lexerState, character),
                defaultStateMap.getOrDefault(lexerState, new LexerState("DEFAULT_STATE")));
    }

    public LexerState getStartState() {
        return new LexerState("START_STATE");
    }
}
