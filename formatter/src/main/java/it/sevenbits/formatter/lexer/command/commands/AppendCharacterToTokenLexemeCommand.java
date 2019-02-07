package it.sevenbits.formatter.lexer.command.commands;

import it.sevenbits.formatter.lexer.Token.TokenBuilder;
import it.sevenbits.formatter.lexer.command.util.LexerCommandArgs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class presents a command, that appends character to the lexeme.
 */
public class AppendCharacterToTokenLexemeCommand implements ILexerCommand {
    private final Logger logger = LoggerFactory.getLogger(AppendCharacterToTokenLexemeCommand.class);
    private TokenBuilder tokenBuilder;
    private LexerCommandArgs lexerCommandArgs;

    /**
     * Constructor of AppendCharacterToTokenLexemeCommand class.
     * Here we set a TokenBuilder and LexerCommandArgs instances.
     *
     * @param tokenBuilder Passed TokenBuilder instance for building a tokens.
     * @param lexerCommandArgs Passed LexerCommandArgs instance,
     *                         where we take a current symbol from lexer
     */
    public AppendCharacterToTokenLexemeCommand(final TokenBuilder tokenBuilder,
                                               final LexerCommandArgs lexerCommandArgs) {
        this.tokenBuilder = tokenBuilder;
        this.lexerCommandArgs = lexerCommandArgs;
    }

    /**
     * This method appends character to the lexeme.
     */
    @Override
    public void execute() {
        logger.info("AppendCharacterToTokenLexemeCommand execute method was called");
        tokenBuilder.appendCharacterToLexeme(lexerCommandArgs.getCharacter());
    }
}

