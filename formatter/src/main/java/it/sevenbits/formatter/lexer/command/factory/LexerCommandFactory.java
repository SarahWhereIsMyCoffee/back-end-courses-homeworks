package it.sevenbits.formatter.lexer.command.factory;

import it.sevenbits.formatter.lexer.statemachine.State;
import it.sevenbits.formatter.lexer.Token.TokenBuilder;
import it.sevenbits.formatter.lexer.command.commands.ILexerCommand;
import it.sevenbits.formatter.lexer.command.util.LexerCommandArgs;

/**
 * This class is a wrapper for LexerCommandRepository, that allows to get commands by Lexer states.
 */
public class LexerCommandFactory {
    private LexerCommandRepository lexerCommandRepository;

    /**
     * Constructor for LexerCommandFactory class.
     * Here we declare a LexerCommandRepository instance
     *
     * @param tokenBuilder Passed TokenBuilder instance to LexerCommandRepository
     * @param lexerCommandArgs - Passed LexerCommandArgs instance to LexerCommandRepository
     */
    public LexerCommandFactory(final TokenBuilder tokenBuilder, final LexerCommandArgs lexerCommandArgs) {
        lexerCommandRepository = new LexerCommandRepository(tokenBuilder, lexerCommandArgs);
    }

    /**
     * This method returns a lexer command by taking an ILexerCommand instance
     * from LexerCommandRepository getCommand() method.
     *
     * @param currentState Passed currentState for taking a new command
     * @return ILexerCommand instance
     */
    public ILexerCommand createCommand(final State currentState) {
        return lexerCommandRepository.getCommand(currentState);
    }
}
