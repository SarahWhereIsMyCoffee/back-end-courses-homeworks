package it.sevenbits.formatter.formatter.command.factory;

import it.sevenbits.formatter.formatter.command.commandArgs.FormatterCommandArgs;
import it.sevenbits.formatter.formatter.command.commands.IFormatterCommand;
import it.sevenbits.formatter.formatter.statemachine.FormatterState;
import it.sevenbits.formatter.lexer.Token.Token;

public class FormatterCommandFactory implements IFormatterCommandFactory {
    private FormatterCommandRepository formatterCommandRepository;

    public FormatterCommandFactory(FormatterCommandArgs formatterCommandArgs) {
        formatterCommandRepository = new FormatterCommandRepository(formatterCommandArgs);
    }

    @Override
    public IFormatterCommand createCommand(FormatterState formatterState) {
        return formatterCommandRepository.getCommand(formatterState);
    }
}
