package it.sevenbits.formatter.formatter.command.commands;

import it.sevenbits.formatter.formatter.command.util.FormatterCommandArgs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class WritingWithNewLineBeforeFormatterCommand implements IFormatterCommand {
    private final Logger logger = LoggerFactory.getLogger(WritingWithNewLineBeforeFormatterCommand.class);
    private FormatterCommandArgs formatterCommandArgs;
    private Character SYMBOL_NEW_LINE;
    private IFormatterCommand indentFormatterCommand;

    public WritingWithNewLineBeforeFormatterCommand(final FormatterCommandArgs formatterCommandArgs) {
        this.formatterCommandArgs = formatterCommandArgs;
        this.SYMBOL_NEW_LINE = '\n';
        indentFormatterCommand = new IndentFormatterCommand(formatterCommandArgs);
    }

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
    }
}
