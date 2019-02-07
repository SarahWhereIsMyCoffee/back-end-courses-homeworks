package it.sevenbits.formatter.lexer.command.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class presents a command, that is needed for ignoring a process
 * in some cases.
 */
public class IgnoreLexemeCommand implements ILexerCommand {
    private final Logger logger = LoggerFactory.getLogger(IgnoreLexemeCommand.class);

    /**
     * This method do nothing but logging the method in system.
     */
    @Override
    public void execute() {
        logger.info("IgnoreLexemeCommand execute method was called");
    }
}
