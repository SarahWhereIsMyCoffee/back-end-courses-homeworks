package it.sevenbits.formatter.formatter.command.factory;

import it.sevenbits.formatter.formatter.command.commandargs.FormatterCommandArgs;
import it.sevenbits.formatter.formatter.command.commands.IFormatterCommand;
import it.sevenbits.formatter.formatter.statemachine.FormatterState;

public class FormatterCommandFactory implements IFormatterCommandFactory {
    private FormatterCommandRepository formatterCommandRepository;

    public FormatterCommandFactory(FormatterCommandArgs formatterCommandArgs) {
        formatterCommandRepository = new FormatterCommandRepository(formatterCommandArgs);
    }

    @Override
    public IFormatterCommand createCommand(FormatterState previousState, FormatterState newState) {
        return formatterCommandRepository.getCommand(previousState, newState);
    }
}
