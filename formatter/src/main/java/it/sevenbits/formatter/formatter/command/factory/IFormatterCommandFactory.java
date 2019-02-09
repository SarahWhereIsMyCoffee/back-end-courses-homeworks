package it.sevenbits.formatter.formatter.command.factory;

import it.sevenbits.formatter.formatter.command.commands.IFormatterCommand;
import it.sevenbits.formatter.formatter.statemachine.FormatterState;

public interface IFormatterCommandFactory {
    IFormatterCommand createCommand(final String lastWrittenLexemeName, final FormatterState newState);
}
