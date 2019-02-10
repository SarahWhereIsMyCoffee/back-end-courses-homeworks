package it.sevenbits.formatter.formatter.command.commands;

import it.sevenbits.formatter.formatter.command.util.FormatterCommandArgs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * This class presents formatter command for defaulting writing of lexemes with new line symbol before.
 */
public class WritingWithNewLineBeforeFormatterCommand implements IFormatterCommand {
    private final Logger logger = LoggerFactory.getLogger(WritingWithNewLineBeforeFormatterCommand.class);
    private FormatterCommandArgs formatterCommandArgs;
    private static final Character SYMBOL_NEW_LINE = '\n';
    private IFormatterCommand indentFormatterCommand;

    /**
     * Constructor if WritingWithNewLineBeforeFormatterCommand class.
     * Here we declare FormatterCommandArgs and IndentFormatterCommand instances.
     *
     * @param formatterCommandArgs FormatterCommandArgs instance
     */
    public WritingWithNewLineBeforeFormatterCommand(final FormatterCommandArgs formatterCommandArgs) {
        this.formatterCommandArgs = formatterCommandArgs;
        indentFormatterCommand = new IndentFormatterCommand(formatterCommandArgs);
    }

    /**
     * This method writes a lexeme to writer, but before it also writes a new line symbol.
     */
    @Override
    public void execute() {
        logger.info("WritingWithNewLineBeforeFormatterCommand execute method was called");
        try {
            formatterCommandArgs.getWriter().write(SYMBOL_NEW_LINE.toString());
            formatterCommandArgs.setLastWrittenLexeme(SYMBOL_NEW_LINE.toString());
            indentFormatterCommand.execute();
            formatterCommandArgs.getWriter().write(formatterCommandArgs.getCurrentLexeme());
        } catch (IOException e) {
            e.printStackTrace();
        }
        formatterCommandArgs.setLastWrittenLexeme(formatterCommandArgs.getCurrentLexeme());
        formatterCommandArgs.setLastWrittenLexemeName(formatterCommandArgs.getCurrentLexemeName());
    }
}
