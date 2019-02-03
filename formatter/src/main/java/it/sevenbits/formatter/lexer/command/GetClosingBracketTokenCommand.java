package it.sevenbits.formatter.lexer.command;

import it.sevenbits.formatter.lexer.Token.Token;

public class GetClosingBracketTokenCommand implements ILexerCommand {
    @Override
    public Token execute() {
        return new Token("LEXEME_CLOSING_CURLY_BRACKET", '}');
    }
}
