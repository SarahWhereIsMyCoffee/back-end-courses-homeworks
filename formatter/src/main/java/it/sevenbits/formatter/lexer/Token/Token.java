package it.sevenbits.formatter.lexer.Token;

public class Token implements IToken{
    private String name;
    private String lexeme;
    public Token(String name, String lexeme) {
        this.name = name;
        this.lexeme = lexeme;
    }
    public Token(String name, Character lexeme) {
        this(name, Character.toString(lexeme));
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getLexeme() {
        return lexeme;
    }
}
