package it.sevenbits.formatter.lexer.factory;

import it.sevenbits.formatter.lexer.LexerState;
import it.sevenbits.formatter.lexer.command.GetClosingBracketTokenCommand;
import it.sevenbits.formatter.lexer.command.GetDefaultTokenCommand;
import it.sevenbits.formatter.lexer.command.GetNewLineTokenCommand;
import it.sevenbits.formatter.lexer.command.GetOpeningBracketTokenCommand;
import it.sevenbits.formatter.lexer.command.GetSemicolonTokenCommand;
import it.sevenbits.formatter.lexer.command.GetSlashTokenCommand;
import it.sevenbits.formatter.lexer.command.GetSpaceTokenCommand;
import it.sevenbits.formatter.lexer.command.ILexerCommand;
import it.sevenbits.formatter.lexer.command.LexerCommandArgs;

import java.util.HashMap;
import java.util.Map;

public class LexerCommandRepository {
    private Map<LexerState, ILexerCommand> commandMap;
    private LexerCommandArgs lexerCommandArgs;

    public LexerCommandRepository(LexerCommandArgs lexerCommandArgs) {
        commandMap = new HashMap<>();
        this.lexerCommandArgs = lexerCommandArgs;

        commandMap.put(new LexerState("OPENING_CURLY_BRACKET_STATE"), new GetOpeningBracketTokenCommand());
        commandMap.put(new LexerState("CLOSING_CURLY_BRACKET_STATE"), new GetClosingBracketTokenCommand());
        commandMap.put(new LexerState("SEMICOLON_STATE"), new GetSemicolonTokenCommand());
        commandMap.put(new LexerState("SPACE_STATE"), new GetSpaceTokenCommand());
        commandMap.put(new LexerState("NEW_LINE_STATE"), new GetNewLineTokenCommand());
        commandMap.put(new LexerState("SLASH_STATE"), new GetSlashTokenCommand());
        commandMap.put(new LexerState("DEFAULT_STATE"), new GetDefaultTokenCommand(lexerCommandArgs));
    }

    public ILexerCommand getCommand(LexerState lexerState) {
        return commandMap.get(lexerState);
    }
}
