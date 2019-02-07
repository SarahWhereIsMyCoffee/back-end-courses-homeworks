package it.sevenbits.formatter.lexer.command.factory;

import it.sevenbits.formatter.lexer.statemachine.State;
import it.sevenbits.formatter.lexer.Token.TokenBuilder;
import it.sevenbits.formatter.lexer.command.commands.AppendCharacterToTokenLexemeCommand;
import it.sevenbits.formatter.lexer.command.commands.ILexerCommand;
import it.sevenbits.formatter.lexer.command.commands.IgnoreLexemeCommand;
import it.sevenbits.formatter.lexer.command.util.LexerCommandArgs;

import java.util.HashMap;
import java.util.Map;

/**
 * This class allows for getting a lexer commands using lexer states.
 */
public class LexerCommandRepository {
    private Map<State, ILexerCommand> commandMap;
    private ILexerCommand appendCharacterToTokenLexemeCommand;
    private ILexerCommand ignoreLexemeCommand;

    /**
     * Constructor of LexerCommandRepository class.
     * Here we declare a HashMap, which were we take a commands.
     * Key - State lexer state, Value - ILexerCommand instance.
     *
     * @param tokenBuilder Passed TokenBuilder instance for transferring to commands.
     * @param lexerCommandArgs Passed LexerCommandArgs instance for transferring to commands.
     */
    public LexerCommandRepository(final TokenBuilder tokenBuilder,
                                  final LexerCommandArgs lexerCommandArgs) {
        ignoreLexemeCommand = new IgnoreLexemeCommand();
        appendCharacterToTokenLexemeCommand =
                new AppendCharacterToTokenLexemeCommand(tokenBuilder, lexerCommandArgs);

        commandMap = new HashMap<>();
        commandMap.put(new State("END_OF_LEXEME_STATE"), ignoreLexemeCommand);
    }

    /**
     * This method implements transferring a new command.
     *
     * @param lexerState Current lexer state for getting a new command.
     * @return State instance
     */
    public ILexerCommand getCommand(final State lexerState) {
        return commandMap.getOrDefault(lexerState, appendCharacterToTokenLexemeCommand);
    }
}
