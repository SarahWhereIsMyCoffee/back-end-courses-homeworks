package it.sevenbits.formatter.lexer.command.util;

/**
 * This class presents an instance that provide a symbol that read in lexer.
 */
public class LexerCommandArgs {
    private Character character;

    /**
     * The method returns symbol that was read in lexer
     * @return Character instance
     */
    public Character getCharacter() {
        return character;
    }

    /**
     * This method sets a symbol that was read in lexer
     * @param character Character instance
     */
    public void setCharacter(final Character character) {
        this.character = character;
    }
}
