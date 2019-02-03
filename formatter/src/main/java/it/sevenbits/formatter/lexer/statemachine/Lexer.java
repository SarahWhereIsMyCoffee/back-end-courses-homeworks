package it.sevenbits.formatter.lexer.statemachine;

import it.sevenbits.formatter.io.reader.IReader;
import it.sevenbits.formatter.lexer.ILexer;
import it.sevenbits.formatter.lexer.LexerException;
import it.sevenbits.formatter.lexer.LexerState;
import it.sevenbits.formatter.lexer.Token.IToken;
import it.sevenbits.formatter.lexer.Token.Token;
import it.sevenbits.formatter.lexer.command.ILexerCommand;
import it.sevenbits.formatter.lexer.command.LexerCommandArgs;
import it.sevenbits.formatter.lexer.factory.LexerCommandRepository;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ILexer implementation that provides lexical analysis of Java source code.
 */
public class Lexer implements ILexer {
    private IReader reader;
    private int currentIntChar;
    private Map<Character, String> symbolsMap;

    private Character SYMBOL_OPENING_BRACKET = '{';
    private Character SYMBOL_CLOSING_BRACKET = '}';
    private Character SYMBOL_SEMICOLON = ';';
    private Character SYMBOL_SPACE = ' ';
    private Character SYMBOL_NEW_LINE = '\n';
    private Character SYMBOL_SLASH = '/';

    private LexerCommandArgs lexerCommandArgs;
    private LexerStateTransition lexerStateTransition;
    private LexerCommandRepository lexerCommandRepository;

    private LexerState currentState = null;
    private ILexerCommand currentCommand;
    /**
     * Here we declare some variables..
     *
     * @param reader - IReader instance, where we take string that will be format
     */
    public Lexer(final IReader reader) {
        lexerStateTransition = new LexerStateTransition();
        lexerCommandArgs = new LexerCommandArgs();
        lexerCommandRepository = new LexerCommandRepository(lexerCommandArgs);

        this.reader = reader;
        try {
            currentIntChar = this.reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        symbolsMap = new HashMap<>();
        symbolsMap.put(SYMBOL_OPENING_BRACKET, "LEXEME_OPENING_CURLY_BRACKET");
        symbolsMap.put(SYMBOL_CLOSING_BRACKET, "LEXEME_CLOSING_CURLY_BRACKET");
        symbolsMap.put(SYMBOL_SEMICOLON, "LEXEME_SEMICOLON");
        symbolsMap.put(SYMBOL_SPACE, "LEXEME_SPACE");
        symbolsMap.put(SYMBOL_NEW_LINE, "LEXEME_NEW_LINE");
        symbolsMap.put(SYMBOL_SLASH, "LEXEME_SLASH");
    }

    /**
     *  Method that returns a single instance.
     * @return Single instance.
     * @throws LexerException Exception that can be thrown during the method work.
     */
    @Override
    public Token readToken() throws LexerException {
        char currentChar = (char) currentIntChar;
        if (!hasNextToken()) {
            return null;
        }
        StringBuilder tokenBuilder = new StringBuilder();
        String tokenName = symbolsMap.get(currentChar);
        if (tokenName != null) {
            try {
                currentIntChar = reader.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            currentState = lexerStateTransition.nextState(currentChar);
            currentCommand = lexerCommandRepository.getCommand(currentState);

            return currentCommand.execute();
        }

        while (symbolsMap.get(currentChar) == null && hasNextToken()) {
            tokenBuilder.append(Character.toString(currentChar));
            try {
                currentIntChar = reader.read();
            } catch (IOException e) {
                throw new LexerException("Read error", e);
            }
            currentChar = (char) currentIntChar;
        }
        currentState = new LexerState("DEFAULT_STATE");
        lexerCommandArgs.setLexeme(tokenBuilder.toString());
        currentCommand = lexerCommandRepository.getCommand(currentState);

        return currentCommand.execute();
    }

    /**
     * Method that reports whether single instance is available for reading.
     *
     * @return Boolean value that indicates the result of method work.
     */
    @Override
    public boolean hasNextToken() {
        return currentIntChar != -1;
    }
}
