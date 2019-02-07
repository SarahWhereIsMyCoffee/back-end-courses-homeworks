package it.sevenbits.formatter.formatter.command.commands;

import it.sevenbits.formatter.formatter.command.commandargs.FormatterCommandArgs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class WritingWithNewLineBeforeFormatterCommand implements IFormatterCommand {
    final static Logger LOGGER = LoggerFactory.getLogger(WritingWithNewLineBeforeFormatterCommand.class);
    private FormatterCommandArgs formatterCommandArgs;
    private Character SYMBOL_NEW_LINE;
    private IFormatterCommand indentFormatterCommand;

    public WritingWithNewLineBeforeFormatterCommand(FormatterCommandArgs formatterCommandArgs) {
        this.formatterCommandArgs = formatterCommandArgs;
        this.SYMBOL_NEW_LINE = '\n';
        indentFormatterCommand = new IndentFormatterCommand(formatterCommandArgs);
    }

    @Override
    public void execute() {
        LOGGER.info("WritingWithNewLineBeforeFormatterCommand execute method was called");
        try {
            formatterCommandArgs.getWriter().write(SYMBOL_NEW_LINE.toString());
            formatterCommandArgs.setLastWrittenLexeme(SYMBOL_NEW_LINE.toString());
            indentFormatterCommand.execute();
            formatterCommandArgs.getWriter().write(formatterCommandArgs.getCurrentLexeme());
        } catch (IOException e) {
            e.printStackTrace();
        }
        formatterCommandArgs.setLastWrittenLexeme(formatterCommandArgs.getCurrentLexeme());
    }
}
