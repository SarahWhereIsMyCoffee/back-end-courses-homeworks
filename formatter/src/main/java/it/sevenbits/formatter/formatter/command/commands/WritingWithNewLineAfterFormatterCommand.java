package it.sevenbits.formatter.formatter.command.commands;

import it.sevenbits.formatter.formatter.command.commandArgs.FormatterCommandArgs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.IOException;

public class WritingWithNewLineAfterFormatterCommand implements IFormatterCommand {
    final static Logger LOGGER = LoggerFactory.getLogger(WritingWithNewLineAfterFormatterCommand.class);
    private FormatterCommandArgs formatterCommandArgs;
    private Character SYMBOL_NEW_LINE;
    private IFormatterCommand indentFormatterCommand;

    public WritingWithNewLineAfterFormatterCommand(FormatterCommandArgs formatterCommandArgs) {
        this.formatterCommandArgs = formatterCommandArgs;
        this.SYMBOL_NEW_LINE = '\n';
        indentFormatterCommand = new IndentFormatterCommand(formatterCommandArgs);
    }

    @Override
    public void execute() {
        indentFormatterCommand.execute();
        LOGGER.info("WritingWithNewLineAfterFormatterCommand execute method was called");
        try {
            formatterCommandArgs.getWriter().write(
                     formatterCommandArgs.getCurrentLexeme() + SYMBOL_NEW_LINE.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        formatterCommandArgs.setLastWrittenLexeme("\n");
    }
}
