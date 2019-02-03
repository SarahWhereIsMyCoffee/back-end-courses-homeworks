package it.sevenbits.formatter.formatter.command.commands;

import it.sevenbits.formatter.formatter.command.commandArgs.FormatterCommandArgs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class WritingWithSpaceBeforeAndNewLineAfterFormatterCommand implements IFormatterCommand {
    final static Logger LOGGER = LoggerFactory.getLogger(WritingWithSpaceBeforeAndNewLineAfterFormatterCommand.class);
    private FormatterCommandArgs formatterCommandArgs;
    private Character SYMBOL_NEW_LINE;
    private Character SYMBOL_SPACE;
    private IFormatterCommand indentFormatterCommand;

    public WritingWithSpaceBeforeAndNewLineAfterFormatterCommand(FormatterCommandArgs formatterCommandArgs) {
        this.formatterCommandArgs = formatterCommandArgs;
        this.SYMBOL_NEW_LINE = '\n';
        this.SYMBOL_SPACE = ' ';
        indentFormatterCommand = new IndentFormatterCommand(formatterCommandArgs);
    }

    @Override
    public void execute() {
        indentFormatterCommand.execute();
        LOGGER.info("WritingWithSpaceBeforeAndNewLineAfterFormatterCommand execute method was called");
        try {
            formatterCommandArgs.getWriter().write(
                    SYMBOL_SPACE.toString() + formatterCommandArgs.getCurrentLexeme() + SYMBOL_NEW_LINE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        formatterCommandArgs.setLastWrittenLexeme("\n");
    }
}
