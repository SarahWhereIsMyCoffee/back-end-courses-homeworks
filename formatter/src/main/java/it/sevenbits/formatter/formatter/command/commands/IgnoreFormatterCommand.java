package it.sevenbits.formatter.formatter.command.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IgnoreFormatterCommand implements IFormatterCommand {
    private final Logger logger = LoggerFactory.getLogger(IgnoreFormatterCommand.class);

    @Override
    public void execute() {
        logger.info("IgnoreFormatterCommand execute method was called");
    }
}
