package it.sevenbits.formatter.lexer.command;

import it.sevenbits.formatter.lexer.Token.Token;

public interface ILexerCommand {
    public Token execute();
}
