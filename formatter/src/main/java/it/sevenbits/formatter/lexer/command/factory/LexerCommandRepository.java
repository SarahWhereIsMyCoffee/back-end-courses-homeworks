package it.sevenbits.formatter.lexer.command.factory;

import it.sevenbits.formatter.lexer.statemachine.LexerState;
import it.sevenbits.formatter.lexer.Token.TokenBuilder;
import it.sevenbits.formatter.lexer.command.commands.AppendCharacterToTokenLexemeCommand;
import it.sevenbits.formatter.lexer.command.commands.ILexerCommand;
import it.sevenbits.formatter.lexer.command.commands.IgnoreLexemeCommand;
import it.sevenbits.formatter.lexer.command.commandargs.LexerCommandArgs;

import java.util.HashMap;
import java.util.Map;

public class LexerCommandRepository {
    private Map<LexerState, ILexerCommand> commandMap;
    private ILexerCommand appendCharacterToTokenLexemeCommand;
    private ILexerCommand ignoreLexemeCommand;

    public LexerCommandRepository(TokenBuilder tokenBuilder, LexerCommandArgs lexerCommandArgs) {
        ignoreLexemeCommand = new IgnoreLexemeCommand();
        appendCharacterToTokenLexemeCommand = new AppendCharacterToTokenLexemeCommand(tokenBuilder, lexerCommandArgs);

        commandMap = new HashMap<>();
        commandMap.put(new LexerState("END_OF_LEXEME_STATE"), ignoreLexemeCommand);
    }

    public ILexerCommand getCommand(LexerState lexerState) {
        return commandMap.getOrDefault(lexerState, appendCharacterToTokenLexemeCommand);
    }
}
