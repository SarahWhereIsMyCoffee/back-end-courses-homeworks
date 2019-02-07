package it.sevenbits.formatter.formatter.command.factory;

import it.sevenbits.formatter.formatter.command.util.FormatterCommandArgs;
import it.sevenbits.formatter.formatter.command.commands.IFormatterCommand;
import it.sevenbits.formatter.formatter.statemachine.FormatterState;

public class FormatterCommandFactory implements IFormatterCommandFactory {
    private FormatterCommandRepository formatterCommandRepository;

    public FormatterCommandFactory(final FormatterCommandArgs formatterCommandArgs) {
        formatterCommandRepository = new FormatterCommandRepository(formatterCommandArgs);
    }

    @Override
    public IFormatterCommand createCommand(final FormatterState previousState,
                                           final FormatterState newState) {
        return formatterCommandRepository.getCommand(previousState, newState);
    }
}
