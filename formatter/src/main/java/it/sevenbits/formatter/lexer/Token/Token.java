package it.sevenbits.formatter.lexer.Token;

/**
 * Implementation of IToken interface. Contains all the functionality of Token class.
 * Inside it contains string name and string lexeme.
 */
public class Token implements IToken {
    private String name;
    private String lexeme;

    /**
     * Overload of constructor that initializes lexeme with passed String instance.
     *
     * @param name String instance that represents name of token.
     * @param lexeme String instance that represents lexeme.
     */
    public Token(final String name, final String lexeme) {
        this.name = name;
        this.lexeme = lexeme;
    }
    /**
     * Overload of constructor that initializes lexeme with passed Character instance.
     *
     * @param name String instance that represents name of token.
     * @param lexeme String instance that represents lexeme.
     */
    public Token(final String name, final Character lexeme) {
        this(name, Character.toString(lexeme));
    }

    /**
     * Method that returns token name.
     * @return String name of token
     */
    @Override
    public String getName() {
        return name;
    }
    /**
     * Method that returns lexeme
     * @return String lexeme
     */
    @Override
    public String getLexeme() {
        return lexeme;
    }
}
