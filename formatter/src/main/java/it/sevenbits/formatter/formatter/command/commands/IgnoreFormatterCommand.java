package it.sevenbits.formatter.formatter.command.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IgnoreFormatterCommand implements IFormatterCommand {
    final static Logger LOGGER = LoggerFactory.getLogger(IgnoreFormatterCommand.class);
    @Override
    public void execute() {
        LOGGER.info("IgnoreFormatterCommand execute method was called");
    }
}
