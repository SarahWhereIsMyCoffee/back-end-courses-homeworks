package it.sevenbits.formatter.lexer;

import it.sevenbits.formatter.lexer.Token.Token;

public interface ILexer {
    public Token readToken();
    public boolean hasNextToken();
}
