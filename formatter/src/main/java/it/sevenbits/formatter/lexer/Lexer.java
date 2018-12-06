package it.sevenbits.formatter.lexer;

import it.sevenbits.formatter.io.reader.IReader;
import it.sevenbits.formatter.lexer.Token.Token;

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

    /**
     * Here we declare some variables..
     *
     * @param reader - IReader instance, where we take string that will be format
     */
    public Lexer(final IReader reader) {
        this.reader = reader;
        try {
            currentIntChar = this.reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        symbolsMap = new HashMap<>();
        symbolsMap.put('{', "SYMBOL_OPENING_BRACKET");
        symbolsMap.put('}', "SYMBOL_CLOSING_BRACKET");
        symbolsMap.put(';', "SYMBOL_SEMICOLON");
        symbolsMap.put(' ', "SYMBOL_SPACE");
        symbolsMap.put('\n', "SYMBOL_NEW_LINE");
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
            return new Token(tokenName, currentChar);
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
        return new Token("DEFAULT_LEXEME", tokenBuilder.toString());
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
