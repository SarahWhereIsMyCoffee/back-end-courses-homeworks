package it.sevenbits.formatter.lexer.command;

import it.sevenbits.formatter.lexer.Token.IToken;
import it.sevenbits.formatter.lexer.Token.Token;

public class GetOpeningBracketTokenCommand implements ILexerCommand {
    @Override
    public Token execute() {
        return new Token("LEXEME_OPENING_CURLY_BRACKET", '{');
    }
}
