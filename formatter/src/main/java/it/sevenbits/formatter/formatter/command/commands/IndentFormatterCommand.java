package it.sevenbits.formatter.formatter.command.commands;

import it.sevenbits.formatter.formatter.command.util.FormatterCommandArgs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

public class IndentFormatterCommand implements IFormatterCommand {
    private String indent = "    ";
    private FormatterCommandArgs formatterCommandArgs;
    private final Logger logger = LoggerFactory.getLogger(IndentFormatterCommand.class);

    public IndentFormatterCommand(final FormatterCommandArgs formatterCommandArgs) {
        this.formatterCommandArgs = formatterCommandArgs;
    }

    @Override
    public void execute() {
        logger.info("IndentFormatterCommand execute method was called");
        if (formatterCommandArgs.getLastWrittenLexeme().equals("\n")) {
            for (int i = 0; i < formatterCommandArgs.getNestingLevel(); i++) {
                try {
                    formatterCommandArgs.getWriter().write(indent);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}