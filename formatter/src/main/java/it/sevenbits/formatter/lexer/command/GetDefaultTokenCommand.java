package it.sevenbits.formatter.lexer.command;

import it.sevenbits.formatter.lexer.Token.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetDefaultTokenCommand implements ILexerCommand {
    private LexerCommandArgs lexerCommandArgs;
    final static Logger LOGGER = LoggerFactory.getLogger(GetDefaultTokenCommand.class);

    public GetDefaultTokenCommand(LexerCommandArgs lexerCommandArgs) {
        this.lexerCommandArgs = lexerCommandArgs;
    }

    @Override
    public Token execute() {
        LOGGER.info("GetDefaultTokenCommand execute method was called");
        return new Token("LEXEME_DEFAULT", lexerCommandArgs.getLexeme());
    }
}
