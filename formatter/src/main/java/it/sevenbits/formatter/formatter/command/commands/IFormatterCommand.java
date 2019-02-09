package it.sevenbits.formatter.formatter.command.commands;

/**
 * This class presents formatter commands.
 * Contains the only method execute(), that do override actions.
 */
public interface IFormatterCommand {
    /**
     * A commands do actions by this method.
     */
    void execute();
}
