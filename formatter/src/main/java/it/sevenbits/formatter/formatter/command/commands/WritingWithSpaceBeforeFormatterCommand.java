package it.sevenbits.formatter.formatter.command.commands;

import it.sevenbits.formatter.formatter.command.util.FormatterCommandArgs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

/**
 * This class presents formatter command for defaulting writing of lexemes with space symbol before.
 */
public class WritingWithSpaceBeforeFormatterCommand implements IFormatterCommand {
    private final Logger logger = LoggerFactory.getLogger(WritingWithNewLineBeforeFormatterCommand.class);
    private FormatterCommandArgs formatterCommandArgs;
    private static final Character SYMBOL_SPACE = ' ';
    private IFormatterCommand indentFormatterCommand;

    /**
     * Constructor if WritingWithSpaceBeforeFormatterCommand class.
     * Here we declare FormatterCommandArgs and IndentFormatterCommand instances.
     *
     * @param formatterCommandArgs FormatterCommandArgs instance
     */
    public WritingWithSpaceBeforeFormatterCommand(final FormatterCommandArgs formatterCommandArgs) {
        this.formatterCommandArgs = formatterCommandArgs;
        indentFormatterCommand = new IndentFormatterCommand(formatterCommandArgs);
    }

    /**
     * This method writes a lexeme to writer, but before it also writes a space symbol.
     */
    @Override
    public void execute() {
        indentFormatterCommand.execute();
        logger.info("WritingWithSpaceBeforeFormatterCommand execute method was called");
        try {
            formatterCommandArgs.getWriter().write(
                    SYMBOL_SPACE.toString() + formatterCommandArgs.getCurrentLexeme());
        } catch (IOException e) {
            e.printStackTrace();
        }
        formatterCommandArgs.setLastWrittenLexeme(formatterCommandArgs.getCurrentLexeme());
        formatterCommandArgs.setLastWrittenLexemeName(formatterCommandArgs.getCurrentLexemeName());
    }
}
