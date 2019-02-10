package it.sevenbits.formatter.formatter.command.commands;

import it.sevenbits.formatter.formatter.command.util.FormatterCommandArgs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * This class presents formatter command for defaulting writing of lexemes.
 */
public class WritingDefaultFormatterCommand implements IFormatterCommand {
    private FormatterCommandArgs formatterCommandArgs;
    private IFormatterCommand indentFormatterCommand;
    private final Logger logger = LoggerFactory.getLogger(WritingDefaultFormatterCommand.class);

    /**
     * Constructor if WritingDefaultFormatterCommand class.
     * Here we declare FormatterCommandArgs instance.
     *
     * @param formatterCommandArgs FormatterCommandArgs instance
     */
    public WritingDefaultFormatterCommand(final FormatterCommandArgs formatterCommandArgs) {
        this.formatterCommandArgs = formatterCommandArgs;
        indentFormatterCommand = new IndentFormatterCommand(formatterCommandArgs);
    }

    /**
     * This method writes a lexeme to writer.
     */
    @Override
    public void execute() {
        indentFormatterCommand.execute();
        logger.info("WritingDefaultFormatterCommand execute method was called");
        try {
            formatterCommandArgs.getWriter().write(formatterCommandArgs.getCurrentLexeme());
        } catch (IOException e) {
            e.printStackTrace();
        }
        formatterCommandArgs.setLastWrittenLexeme(formatterCommandArgs.getCurrentLexeme());
        formatterCommandArgs.setLastWrittenLexemeName(formatterCommandArgs.getCurrentLexemeName());
    }
}
