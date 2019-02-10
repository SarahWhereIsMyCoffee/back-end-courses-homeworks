package it.sevenbits.formatter.formatter.command.factory;

import it.sevenbits.formatter.formatter.command.commands.IFormatterCommand;
import it.sevenbits.formatter.formatter.statemachine.FormatterState;

/**
 * This interface presents an instance for the creating a new command instance in according to last written lexeme name
 * and current state
 */
public interface IFormatterCommandFactory {
    /**
     * This method implements transferring of formatter command in according with last written lexeme
     * and new formatter state.
     *
     * @param lastWrittenLexemeName Last written in IWriter instance lexeme
     * @param currentState Current formatter state
     * @return IFormatterCommand instance
     */
    IFormatterCommand createCommand(final String lastWrittenLexemeName, final FormatterState currentState);
}
