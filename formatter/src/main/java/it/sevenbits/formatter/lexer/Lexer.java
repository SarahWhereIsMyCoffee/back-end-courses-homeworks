package it.sevenbits.formatter.lexer;

import it.sevenbits.formatter.io.reader.IReader;
import it.sevenbits.formatter.lexer.Token.Token;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Lexer implements ILexer {
    private IReader reader;
    private int currentIntChar;
    private Map<Character, String> symbolsMap;

    public Lexer(final IReader reader) {
        this.reader = reader;
        try {
            currentIntChar = this.reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        symbolsMap = new HashMap<>();
        symbolsMap.put( '{', "SYMBOL_OPENING_BRACKET");
        symbolsMap.put( '}', "SYMBOL_CLOSING_BRACKET");
        symbolsMap.put( ';', "SYMBOL_SEMICOLON");
        symbolsMap.put( ' ', "SYMBOL_SPACE");
        symbolsMap.put( '\n', "SYMBOL_NEW_LINE");
    }

    @Override
    public Token readToken() {
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
                e.printStackTrace();
            }
            currentChar = (char) currentIntChar;
        }
        return new Token("DEFAULT_LEXEME", tokenBuilder.toString());
    }

    @Override
    public boolean hasNextToken() {
        return currentIntChar != -1;
    }
}
