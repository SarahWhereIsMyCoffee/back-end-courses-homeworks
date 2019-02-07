package it.sevenbits.formatter.formatter.command.factory;

import it.sevenbits.formatter.formatter.command.util.FormatterCommandArgs;
import it.sevenbits.formatter.formatter.command.commands.IgnoreFormatterCommand;
import it.sevenbits.formatter.formatter.command.commands.WritingDefaultFormatterCommand;
import it.sevenbits.formatter.formatter.command.commands.IFormatterCommand;
import it.sevenbits.formatter.formatter.command.commands.WritingWithNewLineBeforeFormatterCommand;
import it.sevenbits.formatter.formatter.command.commands.WritingWithSpaceBeforeFormatterCommand;
import it.sevenbits.formatter.formatter.statemachine.FormatterState;
import it.sevenbits.formatter.pair.Pair;

import java.util.HashMap;
import java.util.Map;

public class FormatterCommandRepository {
    private Map<Pair<FormatterState, FormatterState>, IFormatterCommand> commandMap;

    private FormatterState START_FORMATTER_STATE;
    private FormatterState OPENING_CURLY_BRACKET_FORMATTER_STATE;
    private FormatterState CLOSING_CURLY_BRACKET_FORMATTER_STATE;
    private FormatterState SEMICOLON_FORMATTER_STATE;
    private FormatterState SPACE_FORMATTER_STATE;
    private FormatterState NEW_LINE_FORMATTER_STATE;
    private FormatterState LINE_COMMENT_FORMATTER_STATE;
    private FormatterState BLOCK_COMMENT_FORMATTER_STATE;
    private FormatterState DEFAULT_LEXEME_FORMATTER_STATE;

    private IFormatterCommand ignoreFormatterCommandFormatterCommand;
    private IFormatterCommand writingDefaultFormatterCommand;
    private IFormatterCommand writingWithNewLineBeforeFormatterCommand;
    private IFormatterCommand writingWithSpaceBeforeFormatterCommand;

    public FormatterCommandRepository(final FormatterCommandArgs formatterCommandArgs) {
        START_FORMATTER_STATE = new FormatterState("START_STATE");
        OPENING_CURLY_BRACKET_FORMATTER_STATE = new FormatterState("OPENING_CURLY_BRACKET_STATE");
        CLOSING_CURLY_BRACKET_FORMATTER_STATE = new FormatterState("CLOSING_CURLY_BRACKET_STATE");
        SEMICOLON_FORMATTER_STATE = new FormatterState("SEMICOLON_STATE");
        SPACE_FORMATTER_STATE = new FormatterState("SPACE_STATE");
        NEW_LINE_FORMATTER_STATE = new FormatterState("NEW_LINE_STATE");
        LINE_COMMENT_FORMATTER_STATE = new FormatterState("LINE_COMMENT_STATE");
        BLOCK_COMMENT_FORMATTER_STATE = new FormatterState("BLOCK_COMMENT_STATE");
        DEFAULT_LEXEME_FORMATTER_STATE = new FormatterState("DEFAULT_LEXEME_STATE");

        ignoreFormatterCommandFormatterCommand = new IgnoreFormatterCommand();
        writingDefaultFormatterCommand = new WritingDefaultFormatterCommand(formatterCommandArgs);
        writingWithNewLineBeforeFormatterCommand = new WritingWithNewLineBeforeFormatterCommand(formatterCommandArgs);
        writingWithSpaceBeforeFormatterCommand = new WritingWithSpaceBeforeFormatterCommand(formatterCommandArgs);

        //Странные переносы строк из-за выхода за 140 символов (checkstyle)
        commandMap = new HashMap<>();
        commandMap.put(new Pair<>(START_FORMATTER_STATE, OPENING_CURLY_BRACKET_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(START_FORMATTER_STATE, CLOSING_CURLY_BRACKET_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(START_FORMATTER_STATE, SEMICOLON_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(START_FORMATTER_STATE, SPACE_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(START_FORMATTER_STATE, NEW_LINE_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(START_FORMATTER_STATE, LINE_COMMENT_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(START_FORMATTER_STATE, BLOCK_COMMENT_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(START_FORMATTER_STATE, DEFAULT_LEXEME_FORMATTER_STATE), writingDefaultFormatterCommand);

        commandMap.put(new Pair<>(OPENING_CURLY_BRACKET_FORMATTER_STATE, OPENING_CURLY_BRACKET_FORMATTER_STATE),
                writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(OPENING_CURLY_BRACKET_FORMATTER_STATE, CLOSING_CURLY_BRACKET_FORMATTER_STATE),
                writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(OPENING_CURLY_BRACKET_FORMATTER_STATE, SEMICOLON_FORMATTER_STATE),
                writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(OPENING_CURLY_BRACKET_FORMATTER_STATE, SPACE_FORMATTER_STATE),
                ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(OPENING_CURLY_BRACKET_FORMATTER_STATE, NEW_LINE_FORMATTER_STATE),
                ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(OPENING_CURLY_BRACKET_FORMATTER_STATE, LINE_COMMENT_FORMATTER_STATE),
                writingWithSpaceBeforeFormatterCommand);
        commandMap.put(new Pair<>(OPENING_CURLY_BRACKET_FORMATTER_STATE, BLOCK_COMMENT_FORMATTER_STATE),
                writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(OPENING_CURLY_BRACKET_FORMATTER_STATE, DEFAULT_LEXEME_FORMATTER_STATE),
                writingWithNewLineBeforeFormatterCommand);


        commandMap.put(new Pair<>(CLOSING_CURLY_BRACKET_FORMATTER_STATE, OPENING_CURLY_BRACKET_FORMATTER_STATE),
                writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(CLOSING_CURLY_BRACKET_FORMATTER_STATE, CLOSING_CURLY_BRACKET_FORMATTER_STATE),
                writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(CLOSING_CURLY_BRACKET_FORMATTER_STATE, SEMICOLON_FORMATTER_STATE),
                writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(CLOSING_CURLY_BRACKET_FORMATTER_STATE, SPACE_FORMATTER_STATE),
                ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(CLOSING_CURLY_BRACKET_FORMATTER_STATE, NEW_LINE_FORMATTER_STATE),
                ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(CLOSING_CURLY_BRACKET_FORMATTER_STATE, LINE_COMMENT_FORMATTER_STATE),
                writingWithSpaceBeforeFormatterCommand);
        commandMap.put(new Pair<>(CLOSING_CURLY_BRACKET_FORMATTER_STATE, BLOCK_COMMENT_FORMATTER_STATE),
                writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(CLOSING_CURLY_BRACKET_FORMATTER_STATE, DEFAULT_LEXEME_FORMATTER_STATE),
                writingWithNewLineBeforeFormatterCommand);


        commandMap.put(new Pair<>(SEMICOLON_FORMATTER_STATE, OPENING_CURLY_BRACKET_FORMATTER_STATE),
                writingWithSpaceBeforeFormatterCommand);
        commandMap.put(new Pair<>(SEMICOLON_FORMATTER_STATE, CLOSING_CURLY_BRACKET_FORMATTER_STATE),
                writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(SEMICOLON_FORMATTER_STATE, SEMICOLON_FORMATTER_STATE),
                writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(SEMICOLON_FORMATTER_STATE, SPACE_FORMATTER_STATE),
                ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(SEMICOLON_FORMATTER_STATE, NEW_LINE_FORMATTER_STATE),
                ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(SEMICOLON_FORMATTER_STATE, LINE_COMMENT_FORMATTER_STATE),
                writingWithSpaceBeforeFormatterCommand);
        commandMap.put(new Pair<>(SEMICOLON_FORMATTER_STATE, BLOCK_COMMENT_FORMATTER_STATE),
                writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(SEMICOLON_FORMATTER_STATE, DEFAULT_LEXEME_FORMATTER_STATE),
                writingWithNewLineBeforeFormatterCommand);


        commandMap.put(new Pair<>(SPACE_FORMATTER_STATE, OPENING_CURLY_BRACKET_FORMATTER_STATE), writingWithSpaceBeforeFormatterCommand);
        commandMap.put(new Pair<>(SPACE_FORMATTER_STATE, CLOSING_CURLY_BRACKET_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(SPACE_FORMATTER_STATE, SEMICOLON_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(SPACE_FORMATTER_STATE, SPACE_FORMATTER_STATE), ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(SPACE_FORMATTER_STATE, NEW_LINE_FORMATTER_STATE), ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(SPACE_FORMATTER_STATE, LINE_COMMENT_FORMATTER_STATE), writingWithSpaceBeforeFormatterCommand);
        commandMap.put(new Pair<>(SPACE_FORMATTER_STATE, BLOCK_COMMENT_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(SPACE_FORMATTER_STATE, DEFAULT_LEXEME_FORMATTER_STATE), writingWithSpaceBeforeFormatterCommand);

        commandMap.put(new Pair<>(NEW_LINE_FORMATTER_STATE, OPENING_CURLY_BRACKET_FORMATTER_STATE),
                writingWithSpaceBeforeFormatterCommand);
        commandMap.put(new Pair<>(NEW_LINE_FORMATTER_STATE, CLOSING_CURLY_BRACKET_FORMATTER_STATE),
                writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(NEW_LINE_FORMATTER_STATE, SEMICOLON_FORMATTER_STATE),
                writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(NEW_LINE_FORMATTER_STATE, SPACE_FORMATTER_STATE),
                ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(NEW_LINE_FORMATTER_STATE, NEW_LINE_FORMATTER_STATE),
                ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(NEW_LINE_FORMATTER_STATE, LINE_COMMENT_FORMATTER_STATE),
                writingWithSpaceBeforeFormatterCommand);
        commandMap.put(new Pair<>(NEW_LINE_FORMATTER_STATE, BLOCK_COMMENT_FORMATTER_STATE),
                writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(NEW_LINE_FORMATTER_STATE, DEFAULT_LEXEME_FORMATTER_STATE),
                writingWithSpaceBeforeFormatterCommand);


        commandMap.put(new Pair<>(LINE_COMMENT_FORMATTER_STATE, OPENING_CURLY_BRACKET_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(LINE_COMMENT_FORMATTER_STATE, CLOSING_CURLY_BRACKET_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(LINE_COMMENT_FORMATTER_STATE, SEMICOLON_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(LINE_COMMENT_FORMATTER_STATE, SPACE_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(LINE_COMMENT_FORMATTER_STATE, NEW_LINE_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(LINE_COMMENT_FORMATTER_STATE, LINE_COMMENT_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(LINE_COMMENT_FORMATTER_STATE, BLOCK_COMMENT_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(LINE_COMMENT_FORMATTER_STATE, DEFAULT_LEXEME_FORMATTER_STATE), writingDefaultFormatterCommand);


        commandMap.put(new Pair<>(BLOCK_COMMENT_FORMATTER_STATE, OPENING_CURLY_BRACKET_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(BLOCK_COMMENT_FORMATTER_STATE, CLOSING_CURLY_BRACKET_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(BLOCK_COMMENT_FORMATTER_STATE, SEMICOLON_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(BLOCK_COMMENT_FORMATTER_STATE, SPACE_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(BLOCK_COMMENT_FORMATTER_STATE, NEW_LINE_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(BLOCK_COMMENT_FORMATTER_STATE, LINE_COMMENT_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(BLOCK_COMMENT_FORMATTER_STATE, BLOCK_COMMENT_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(BLOCK_COMMENT_FORMATTER_STATE, DEFAULT_LEXEME_FORMATTER_STATE), writingDefaultFormatterCommand);


        commandMap.put(new Pair<>(DEFAULT_LEXEME_FORMATTER_STATE, OPENING_CURLY_BRACKET_FORMATTER_STATE),
                writingWithSpaceBeforeFormatterCommand);
        commandMap.put(new Pair<>(DEFAULT_LEXEME_FORMATTER_STATE, CLOSING_CURLY_BRACKET_FORMATTER_STATE),
                writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(DEFAULT_LEXEME_FORMATTER_STATE, SEMICOLON_FORMATTER_STATE),
                writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(DEFAULT_LEXEME_FORMATTER_STATE, SPACE_FORMATTER_STATE),
                ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(DEFAULT_LEXEME_FORMATTER_STATE, NEW_LINE_FORMATTER_STATE),
                ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(DEFAULT_LEXEME_FORMATTER_STATE, LINE_COMMENT_FORMATTER_STATE),
                writingWithSpaceBeforeFormatterCommand);
        commandMap.put(new Pair<>(DEFAULT_LEXEME_FORMATTER_STATE, BLOCK_COMMENT_FORMATTER_STATE),
                writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(DEFAULT_LEXEME_FORMATTER_STATE, DEFAULT_LEXEME_FORMATTER_STATE),
                writingWithSpaceBeforeFormatterCommand);
    }

    public IFormatterCommand getCommand(final FormatterState previousState, final FormatterState newState) {
        return commandMap.getOrDefault(new Pair<>(previousState, newState), new IgnoreFormatterCommand());
    }
}
