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

/**
 * This class make it possible to get next formatter state in according to last written
 * lexeme and current state.
 */
public class FormatterCommandRepository {
    private Map<Pair<String, FormatterState>, IFormatterCommand> commandMap;

    private static final FormatterState START_FORMATTER_STATE = new FormatterState("START_STATE");
    private static final FormatterState OPENING_CURLY_BRACKET_FORMATTER_STATE = new FormatterState("OPENING_CURLY_BRACKET_STATE");
    private static final FormatterState CLOSING_CURLY_BRACKET_FORMATTER_STATE = new FormatterState("CLOSING_CURLY_BRACKET_STATE");
    private static final FormatterState SEMICOLON_FORMATTER_STATE = new FormatterState("SEMICOLON_STATE");
    private static final FormatterState SPACE_FORMATTER_STATE = new FormatterState("SPACE_STATE");
    private static final FormatterState NEW_LINE_FORMATTER_STATE = new FormatterState("NEW_LINE_STATE");
    private static final FormatterState LINE_COMMENT_FORMATTER_STATE = new FormatterState("LINE_COMMENT_STATE");
    private static final FormatterState BLOCK_COMMENT_FORMATTER_STATE = new FormatterState("BLOCK_COMMENT_STATE");
    private static final FormatterState DEFAULT_LEXEME_FORMATTER_STATE = new FormatterState("DEFAULT_LEXEME_STATE");

    private static final String OPENING_CURLY_BRACKET_LEXEME_NAME = "LEXEME_OPENING_CURLY_BRACKET";
    private static final String CLOSING_CURLY_BRACKET_LEXEME_NAME = "LEXEME_CLOSING_CURLY_BRACKET";
    private static final String SEMICOLON_LEXEME_NAME = "LEXEME_SEMICOLON";
    private static final String SPACE_LEXEME_NAME = "LEXEME_SPACE";
    private static final String NEW_LINE_LEXEME_NAME = "LEXEME_NEW_LINE";
    private static final String LINE_COMMENT_LEXEME_NAME = "LEXEME_LINE_COMMENT";
    private static final String BLOCK_COMMENT_LEXEME_NAME = "LEXEME_BLOCK_COMMENT";
    private static final String DEFAULT_LEXEME_NAME = "LEXEME_DEFAULT";

    private IFormatterCommand ignoreFormatterCommandFormatterCommand;
    private IFormatterCommand writingDefaultFormatterCommand;
    private IFormatterCommand writingWithNewLineBeforeFormatterCommand;
    private IFormatterCommand writingWithSpaceBeforeFormatterCommand;

    /**
     * Constructor of FormatterCommandRepository class.
     * Here we put a pairs to the HashMap: Key - Pair class instance (String, FM state), Value - state
     *
     * @param formatterCommandArgs FormatterCommandArgs instance we set in this class.
     */
    public FormatterCommandRepository(final FormatterCommandArgs formatterCommandArgs) {
        commandMap = new HashMap<>();
        ignoreFormatterCommandFormatterCommand = new IgnoreFormatterCommand();
        writingDefaultFormatterCommand = new WritingDefaultFormatterCommand(formatterCommandArgs);
        writingWithNewLineBeforeFormatterCommand = new WritingWithNewLineBeforeFormatterCommand(formatterCommandArgs);
        writingWithSpaceBeforeFormatterCommand = new WritingWithSpaceBeforeFormatterCommand(formatterCommandArgs);

        commandMap.put(new Pair<>(
                OPENING_CURLY_BRACKET_LEXEME_NAME, OPENING_CURLY_BRACKET_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                OPENING_CURLY_BRACKET_LEXEME_NAME, CLOSING_CURLY_BRACKET_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                OPENING_CURLY_BRACKET_LEXEME_NAME, SEMICOLON_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                OPENING_CURLY_BRACKET_LEXEME_NAME, SPACE_FORMATTER_STATE), ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(
                OPENING_CURLY_BRACKET_LEXEME_NAME, NEW_LINE_FORMATTER_STATE), ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(
                OPENING_CURLY_BRACKET_LEXEME_NAME, LINE_COMMENT_FORMATTER_STATE), writingWithSpaceBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                OPENING_CURLY_BRACKET_LEXEME_NAME, BLOCK_COMMENT_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                OPENING_CURLY_BRACKET_LEXEME_NAME, DEFAULT_LEXEME_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);


        commandMap.put(new Pair<>(
                CLOSING_CURLY_BRACKET_LEXEME_NAME, START_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(
                CLOSING_CURLY_BRACKET_LEXEME_NAME, OPENING_CURLY_BRACKET_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                CLOSING_CURLY_BRACKET_LEXEME_NAME, CLOSING_CURLY_BRACKET_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                CLOSING_CURLY_BRACKET_LEXEME_NAME, SEMICOLON_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                CLOSING_CURLY_BRACKET_LEXEME_NAME, SPACE_FORMATTER_STATE), ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(
                CLOSING_CURLY_BRACKET_LEXEME_NAME, NEW_LINE_FORMATTER_STATE), ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(
                CLOSING_CURLY_BRACKET_LEXEME_NAME, LINE_COMMENT_FORMATTER_STATE), writingWithSpaceBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                CLOSING_CURLY_BRACKET_LEXEME_NAME, BLOCK_COMMENT_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                CLOSING_CURLY_BRACKET_LEXEME_NAME, DEFAULT_LEXEME_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);


        commandMap.put(new Pair<>(
                SEMICOLON_LEXEME_NAME, START_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(
                SEMICOLON_LEXEME_NAME, OPENING_CURLY_BRACKET_FORMATTER_STATE), writingWithSpaceBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                SEMICOLON_LEXEME_NAME, CLOSING_CURLY_BRACKET_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(SEMICOLON_LEXEME_NAME, SEMICOLON_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                SEMICOLON_LEXEME_NAME, SPACE_FORMATTER_STATE), ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(
                SEMICOLON_LEXEME_NAME, NEW_LINE_FORMATTER_STATE), ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(
                SEMICOLON_LEXEME_NAME, LINE_COMMENT_FORMATTER_STATE), writingWithSpaceBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                SEMICOLON_LEXEME_NAME, BLOCK_COMMENT_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                SEMICOLON_LEXEME_NAME, DEFAULT_LEXEME_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);

        commandMap.put(new Pair<>(
                SPACE_LEXEME_NAME, START_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(
                SPACE_LEXEME_NAME, OPENING_CURLY_BRACKET_FORMATTER_STATE), writingWithSpaceBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                SPACE_LEXEME_NAME, CLOSING_CURLY_BRACKET_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                SPACE_LEXEME_NAME, SEMICOLON_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(
                SPACE_LEXEME_NAME, SPACE_FORMATTER_STATE), ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(
                SPACE_LEXEME_NAME, NEW_LINE_FORMATTER_STATE), ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(
                SPACE_LEXEME_NAME, LINE_COMMENT_FORMATTER_STATE), writingWithSpaceBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                SPACE_LEXEME_NAME, BLOCK_COMMENT_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                SPACE_LEXEME_NAME, DEFAULT_LEXEME_FORMATTER_STATE), writingWithSpaceBeforeFormatterCommand);


        commandMap.put(new Pair<>(
                NEW_LINE_LEXEME_NAME, START_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(
                NEW_LINE_LEXEME_NAME, OPENING_CURLY_BRACKET_FORMATTER_STATE), writingWithSpaceBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                NEW_LINE_LEXEME_NAME, CLOSING_CURLY_BRACKET_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                NEW_LINE_LEXEME_NAME, SEMICOLON_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(
                NEW_LINE_LEXEME_NAME, SPACE_FORMATTER_STATE), ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(
                NEW_LINE_LEXEME_NAME, NEW_LINE_FORMATTER_STATE), ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(
                NEW_LINE_LEXEME_NAME, LINE_COMMENT_FORMATTER_STATE), writingWithSpaceBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                NEW_LINE_LEXEME_NAME, BLOCK_COMMENT_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                NEW_LINE_LEXEME_NAME, DEFAULT_LEXEME_FORMATTER_STATE), writingWithSpaceBeforeFormatterCommand);


        commandMap.put(new Pair<>(
                LINE_COMMENT_LEXEME_NAME, START_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                LINE_COMMENT_LEXEME_NAME, OPENING_CURLY_BRACKET_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                LINE_COMMENT_LEXEME_NAME, CLOSING_CURLY_BRACKET_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                LINE_COMMENT_LEXEME_NAME, SEMICOLON_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                LINE_COMMENT_LEXEME_NAME, SPACE_FORMATTER_STATE), ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(
                LINE_COMMENT_LEXEME_NAME, NEW_LINE_FORMATTER_STATE), ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(
                LINE_COMMENT_LEXEME_NAME, LINE_COMMENT_FORMATTER_STATE), writingWithSpaceBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                LINE_COMMENT_LEXEME_NAME, BLOCK_COMMENT_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                LINE_COMMENT_LEXEME_NAME, DEFAULT_LEXEME_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);


        commandMap.put(new Pair<>(
                BLOCK_COMMENT_LEXEME_NAME, START_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                BLOCK_COMMENT_LEXEME_NAME, OPENING_CURLY_BRACKET_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                BLOCK_COMMENT_LEXEME_NAME, CLOSING_CURLY_BRACKET_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                BLOCK_COMMENT_LEXEME_NAME, SEMICOLON_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                BLOCK_COMMENT_LEXEME_NAME, SPACE_FORMATTER_STATE), ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(
                BLOCK_COMMENT_LEXEME_NAME, NEW_LINE_FORMATTER_STATE), ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(
                BLOCK_COMMENT_LEXEME_NAME, LINE_COMMENT_FORMATTER_STATE), writingWithSpaceBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                BLOCK_COMMENT_LEXEME_NAME, BLOCK_COMMENT_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                BLOCK_COMMENT_LEXEME_NAME, DEFAULT_LEXEME_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);


        commandMap.put(new Pair<>(
                DEFAULT_LEXEME_NAME, START_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(
                DEFAULT_LEXEME_NAME, OPENING_CURLY_BRACKET_FORMATTER_STATE), writingWithSpaceBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                DEFAULT_LEXEME_NAME, CLOSING_CURLY_BRACKET_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                DEFAULT_LEXEME_NAME, SEMICOLON_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>(
                DEFAULT_LEXEME_NAME, SPACE_FORMATTER_STATE), ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(
                DEFAULT_LEXEME_NAME, NEW_LINE_FORMATTER_STATE), ignoreFormatterCommandFormatterCommand);
        commandMap.put(new Pair<>(
                DEFAULT_LEXEME_NAME, LINE_COMMENT_FORMATTER_STATE), writingWithSpaceBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                DEFAULT_LEXEME_NAME, BLOCK_COMMENT_FORMATTER_STATE), writingWithNewLineBeforeFormatterCommand);
        commandMap.put(new Pair<>(
                DEFAULT_LEXEME_NAME, DEFAULT_LEXEME_FORMATTER_STATE), writingWithSpaceBeforeFormatterCommand);


        commandMap.put(new Pair<>("", START_FORMATTER_STATE), writingDefaultFormatterCommand);
        commandMap.put(new Pair<>("", DEFAULT_LEXEME_FORMATTER_STATE), writingDefaultFormatterCommand);
    }

    /**
     * This method returns next state according to last written lexeme and current state
     * @param lastWrittenLexemeName Last written in IWriter instance lexeme.
     * @param currentState Current formatter state
     * @return IFormatterCommand instance.
     */
    public IFormatterCommand getCommand(final String lastWrittenLexemeName, final FormatterState currentState) {
        return commandMap.getOrDefault(new Pair<>(lastWrittenLexemeName, currentState), new IgnoreFormatterCommand());
    }
}
