package it.sevenbits.formatter.lexer.statemachine;

import it.sevenbits.formatter.pair.Pair;
import java.util.HashMap;
import java.util.Map;

/**
 * This class allows for transition from one state to another.
 */
public class StateMap {
    private Map<Pair<State, Character>, State> lexerStateMap;
    private Map<State, State> defaultStateMap;

    private static final Character SYMBOL_OPENING_CURLY_BRACKET = '{';
    private static final Character SYMBOL_CLOSING_CURLY_BRACKET = '}';
    private static final Character SYMBOL_SEMICOLON = ';';
    private static final Character SYMBOL_SPACE = ' ';
    private static final Character SYMBOL_NEW_LINE = '\n';
    private static final Character SYMBOL_SLASH = '/';
    private static final Character SYMBOL_STAR = '*';

    private static final State START_STATE = new State("START_STATE");
    private static final State OPENING_CURLY_BRACKET_STATE = new State("OPENING_CURLY_BRACKET_STATE");
    private static final State CLOSING_CURLY_BRACKET_STATE = new State("CLOSING_CURLY_BRACKET_STATE");
    private static final State SEMICOLON_STATE = new State("SEMICOLON_STATE");
    private static final State SPACE_STATE = new State("SPACE_STATE");
    private static final State NEW_LINE_STATE = new State("NEW_LINE_STATE");
    private static final State POTENTIONAL_COMMENT_STATE = new State("POTENTIONAL_COMMENT_STATE");
    private static final State LINE_COMMENT_STATE = new State("LINE_COMMENT_STATE");
    private static final State BLOCK_COMMENT_STATE = new State("BLOCK_COMMENT_STATE");
    private static final State POTENTIONAL_END_OF_BLOCK_COMMENT_STATE = new State("POTENTIONAL_END_OF_BLOCK_COMMENT_STATE");
    private static final State END_OF_LEXEME_STATE = new State("END_OF_LEXEME_STATE");
    private static final State DEFAULT_STATE = new State("DEFAULT_STATE");


    /**
     * Constructor of StateMap class.
     * Here we declare two HashMaps: lexerStateMap and defaultStateMap.
     *
     * First map allows to get a new state by previous state and new symbol we got form reader.
     * Second map allows to get a new state by read symbol, that is necessary if some state
     * should depends only on read symbol regardless current state.
     */
    public StateMap() {
        lexerStateMap = new HashMap<>();
        defaultStateMap = new HashMap<>();


        defaultStateMap.put(OPENING_CURLY_BRACKET_STATE, END_OF_LEXEME_STATE);
        defaultStateMap.put(CLOSING_CURLY_BRACKET_STATE, END_OF_LEXEME_STATE);
        defaultStateMap.put(SEMICOLON_STATE, END_OF_LEXEME_STATE);
        defaultStateMap.put(SPACE_STATE, END_OF_LEXEME_STATE);
        defaultStateMap.put(NEW_LINE_STATE, END_OF_LEXEME_STATE);
        defaultStateMap.put(START_STATE, END_OF_LEXEME_STATE);


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

    /**
     * This method returns a new lexer state by necessary value from state HashMap.
     *
     * @param lexerState - current lexer state.
     * @param character - transferred from Reader symbol.
     * @return - State implementation.
     */
    public State getNextState(final State lexerState, final Character character) {
        return lexerStateMap.getOrDefault(new Pair<>(lexerState, character),
                defaultStateMap.getOrDefault(lexerState, new State("DEFAULT_STATE")));
    }

    /**
     * This method returns the start lexer state.
     *
     * @return - State implementation.
     */
    public State getStartState() {
        return START_STATE;
    }
}
