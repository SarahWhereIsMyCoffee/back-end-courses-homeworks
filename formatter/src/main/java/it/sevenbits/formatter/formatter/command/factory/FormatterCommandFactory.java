package it.sevenbits.formatter.formatter.command.factory;

import it.sevenbits.formatter.formatter.command.util.FormatterCommandArgs;
import it.sevenbits.formatter.formatter.command.commands.IFormatterCommand;
import it.sevenbits.formatter.formatter.statemachine.FormatterState;

/**
 * This class presents a wrapper for the FormatterCommandRepository class.
 */
public class FormatterCommandFactory implements IFormatterCommandFactory {
    private FormatterCommandRepository formatterCommandRepository;

    /**
     * Constructor of the class, where we declare the FormatterCommandRepository instance.
     *
     * @param formatterCommandArgs FormatterCommandArgs instance, that is needed for program's work.
     */
    public FormatterCommandFactory(final FormatterCommandArgs formatterCommandArgs) {
        formatterCommandRepository = new FormatterCommandRepository(formatterCommandArgs);
    }

    /**
     * This method implements transferring of formatter command in according with last written lexeme
     * and new formatter state.
     *
     * @param lastWrittenLexemeName
     * @param newState
     * @return
     */
    @Override
    public IFormatterCommand createCommand(final String lastWrittenLexemeName,
                                           final FormatterState newState) {
        return formatterCommandRepository.getCommand(lastWrittenLexemeName, newState);
    }
}
