package it.sevenbits.formatter.lexer.command.factory;

import it.sevenbits.formatter.lexer.statemachine.LexerState;
import it.sevenbits.formatter.lexer.Token.TokenBuilder;
import it.sevenbits.formatter.lexer.command.commands.ILexerCommand;
import it.sevenbits.formatter.lexer.command.commandargs.LexerCommandArgs;

public class LexerCommandFactory {
    private LexerCommandRepository lexerCommandRepository;
    private TokenBuilder tokenBuilder;
    private Character character;

    public LexerCommandFactory(TokenBuilder tokenBuilder, LexerCommandArgs lexerCommandArgs) {
        this.tokenBuilder = tokenBuilder;
        this.character = character;
        lexerCommandRepository = new LexerCommandRepository(tokenBuilder, lexerCommandArgs);
    }

    public ILexerCommand createCommand(LexerState currentState) {
        return lexerCommandRepository.getCommand(currentState);
    }
}
