package it.sevenbits.formatter.lexer.Token;

/**
 * Interface that declares a functionality for lexical token.
 */
public interface IToken {
     /**
      * Method that returns token name.
      * @return String name of token
      */
     String getName();

     /**
      * Method that returns lexeme
      * @return String lexeme
      */
     String getLexeme();
}
