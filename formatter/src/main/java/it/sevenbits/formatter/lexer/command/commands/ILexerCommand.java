package it.sevenbits.formatter.lexer.command.commands;

/**
 * An interface for lexer commands.
 * Contains the only execute method, that performs a predefined task.
 */
public interface ILexerCommand {
    /**
     * Method, that performs a predefined task.
     */
    void execute();
}
