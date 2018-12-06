package it.sevenbits.formatter.lexer;

import it.sevenbits.formatter.lexer.Token.Token;

/**
 * Interface that declares a functionality for providing lexical analysis of Java source code.
 */
public interface ILexer {
    /**
     * Method that returns a single IToken instance.
     *
     * @return  Single IToken instance.
     * @throws LexerException LexerException Exception that can be thrown during the method work.
     */
    Token readToken() throws LexerException;
    /**
     *  Method that reports whether single IToken instance is available for reading.
     * @return Boolean value that indicates the result of method work.
     */
    boolean hasNextToken();
}
