package it.sevenbits.formatter.formatter.command.commands;

import it.sevenbits.formatter.formatter.command.commandargs.FormatterCommandArgs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class WritingDefaultFormatterCommand implements IFormatterCommand {
    private FormatterCommandArgs formatterCommandArgs;
    private IFormatterCommand indentFormatterCommand;
    final static Logger LOGGER = LoggerFactory.getLogger(WritingDefaultFormatterCommand.class);

    public WritingDefaultFormatterCommand(FormatterCommandArgs formatterCommandArgs) {
        this.formatterCommandArgs = formatterCommandArgs;
        indentFormatterCommand = new IndentFormatterCommand(formatterCommandArgs);
    }

    @Override
    public void execute() {
        indentFormatterCommand.execute();
        LOGGER.info("WritingDefaultFormatterCommand execute method was called");
        try {
            formatterCommandArgs.getWriter().write(formatterCommandArgs.getCurrentLexeme());
        } catch (IOException e) {
            e.printStackTrace();
        }
        formatterCommandArgs.setLastWrittenLexeme(formatterCommandArgs.getCurrentLexeme());
    }
}
