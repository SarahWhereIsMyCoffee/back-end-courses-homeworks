package it.sevenbits.formatter.formatter.command.commands;

import it.sevenbits.formatter.formatter.command.util.FormatterCommandArgs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class WritingDefaultFormatterCommand implements IFormatterCommand {
    private FormatterCommandArgs formatterCommandArgs;
    private IFormatterCommand indentFormatterCommand;
    private final Logger logger = LoggerFactory.getLogger(WritingDefaultFormatterCommand.class);

    public WritingDefaultFormatterCommand(final FormatterCommandArgs formatterCommandArgs) {
        this.formatterCommandArgs = formatterCommandArgs;
        indentFormatterCommand = new IndentFormatterCommand(formatterCommandArgs);
    }

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
    }
}
