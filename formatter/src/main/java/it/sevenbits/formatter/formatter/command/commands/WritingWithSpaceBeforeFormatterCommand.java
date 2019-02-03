package it.sevenbits.formatter.formatter.command.commands;

import it.sevenbits.formatter.formatter.command.commandArgs.FormatterCommandArgs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

public class WritingWithSpaceBeforeFormatterCommand implements IFormatterCommand {
    final static Logger LOGGER = LoggerFactory.getLogger(WritingWithNewLineBeforeFormatterCommand.class);
    private FormatterCommandArgs formatterCommandArgs;
    private Character SYMBOL_SPACE;
    private IFormatterCommand indentFormatterCommand;

    public WritingWithSpaceBeforeFormatterCommand(FormatterCommandArgs formatterCommandArgs) {
        this.formatterCommandArgs = formatterCommandArgs;
        this.SYMBOL_SPACE = ' ';
        indentFormatterCommand = new IndentFormatterCommand(formatterCommandArgs);
    }

    @Override
    public void execute() {
        indentFormatterCommand.execute();
        LOGGER.info("WritingWithSpaceBeforeFormatterCommand execute method was called");
        try {
            formatterCommandArgs.getWriter().write(
                    SYMBOL_SPACE.toString() + formatterCommandArgs.getCurrentLexeme());
        } catch (IOException e) {
            e.printStackTrace();
        }
        formatterCommandArgs.setLastWrittenLexeme(formatterCommandArgs.getCurrentLexeme());
    }
}
