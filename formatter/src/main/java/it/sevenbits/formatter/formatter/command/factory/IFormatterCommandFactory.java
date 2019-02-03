package it.sevenbits.formatter.formatter.command.factory;

import it.sevenbits.formatter.formatter.command.commands.IFormatterCommand;
import it.sevenbits.formatter.formatter.statemachine.FormatterState;
import it.sevenbits.formatter.lexer.Token.Token;

public interface IFormatterCommandFactory {
    public IFormatterCommand createCommand(FormatterState formatterState);
}
