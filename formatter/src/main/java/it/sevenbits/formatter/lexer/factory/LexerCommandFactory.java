package it.sevenbits.formatter.lexer.factory;

import it.sevenbits.formatter.lexer.LexerState;
import it.sevenbits.formatter.lexer.command.ILexerCommand;
import it.sevenbits.formatter.lexer.command.LexerCommandArgs;

public class LexerCommandFactory {
    private LexerCommandRepository formatterCommandRepository;

    public LexerCommandFactory(LexerCommandArgs lexerCommandArgs) {
        formatterCommandRepository = new LexerCommandRepository(lexerCommandArgs);
    }

    public ILexerCommand createCommand(LexerState formatterState) {
        return formatterCommandRepository.getCommand(formatterState);
    }
}
