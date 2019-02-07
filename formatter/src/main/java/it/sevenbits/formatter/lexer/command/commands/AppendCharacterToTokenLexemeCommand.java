package it.sevenbits.formatter.lexer.command.commands;

import it.sevenbits.formatter.lexer.Token.TokenBuilder;
import it.sevenbits.formatter.lexer.command.commandargs.LexerCommandArgs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppendCharacterToTokenLexemeCommand implements ILexerCommand {
    final static Logger LOGGER = LoggerFactory.getLogger(AppendCharacterToTokenLexemeCommand.class);
    private TokenBuilder tokenBuilder;
    private LexerCommandArgs lexerCommandArgs;

    public AppendCharacterToTokenLexemeCommand(TokenBuilder tokenBuilder, LexerCommandArgs lexerCommandArgs) {
        this.tokenBuilder = tokenBuilder;
        this.lexerCommandArgs = lexerCommandArgs;
    }

    @Override
    public void execute() {
        LOGGER.info("AppendCharacterToTokenLexemeCommand execute method was called");
        tokenBuilder.appendCharacterToLexeme(lexerCommandArgs.getCharacter());
    }
}

