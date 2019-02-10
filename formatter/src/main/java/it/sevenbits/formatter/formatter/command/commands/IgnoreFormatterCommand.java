package it.sevenbits.formatter.formatter.command.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class presents formatter command for ignoring some actions.
 */
public class IgnoreFormatterCommand implements IFormatterCommand {
    private final Logger logger = LoggerFactory.getLogger(IgnoreFormatterCommand.class);

    /**
     * This method do nothing but logging this method in system.
     */
    @Override
    public void execute() {
        logger.info("IgnoreFormatterCommand execute method was called");
    }
}
