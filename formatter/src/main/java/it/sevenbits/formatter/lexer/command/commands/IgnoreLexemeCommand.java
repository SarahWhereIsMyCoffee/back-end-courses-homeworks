package it.sevenbits.formatter.lexer.command.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IgnoreLexemeCommand implements ILexerCommand {
    final static Logger LOGGER = LoggerFactory.getLogger(IgnoreLexemeCommand.class);
    @Override
    public void execute() {
        LOGGER.info("IgnoreLexemeCommand execute method was called");
    }
}
