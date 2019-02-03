package it.sevenbits.formatter.formatter.command.factory;

import it.sevenbits.formatter.formatter.command.commandArgs.FormatterCommandArgs;
import it.sevenbits.formatter.formatter.command.commands.IgnoreFormatterCommand;
import it.sevenbits.formatter.formatter.command.commands.WritingDefaultFormatterCommand;
import it.sevenbits.formatter.formatter.command.commands.IFormatterCommand;
import it.sevenbits.formatter.formatter.command.commands.WritingWithNewLineAfterFormatterCommand;
import it.sevenbits.formatter.formatter.command.commands.WritingWithNewLineBeforeFormatterCommand;
import it.sevenbits.formatter.formatter.command.commands.WritingWithSpaceBeforeAndNewLineAfterFormatterCommand;
import it.sevenbits.formatter.formatter.command.commands.WritingWithSpaceBeforeFormatterCommand;
import it.sevenbits.formatter.formatter.statemachine.FormatterState;
import java.util.HashMap;
import java.util.Map;

public class FormatterCommandRepository {
    private Map<FormatterState, IFormatterCommand> commandMap;

    public FormatterCommandRepository(FormatterCommandArgs formatterCommandArgs) {
        commandMap = new HashMap<>();

        commandMap.put(new FormatterState("WRITE_DEFAULT"), new WritingDefaultFormatterCommand(formatterCommandArgs));
        commandMap.put(new FormatterState("WRITE_WITH_NEW_LINE_AFTER"), new WritingWithNewLineAfterFormatterCommand(formatterCommandArgs));
        commandMap.put(new FormatterState("WRITE_WITH_SPACE_BEFORE"), new WritingWithSpaceBeforeFormatterCommand(formatterCommandArgs));
        commandMap.put(new FormatterState("WRITE_WITH_NEW_LINE_BEFORE"), new WritingWithNewLineBeforeFormatterCommand(formatterCommandArgs));
        commandMap.put(new FormatterState("WRITE_WITH_SPACE_BEFORE_AND_NEW_LINE_AFTER"), new WritingWithSpaceBeforeAndNewLineAfterFormatterCommand(formatterCommandArgs));
      }

    public IFormatterCommand getCommand(FormatterState formatterState) {
        return commandMap.getOrDefault(formatterState, new IgnoreFormatterCommand());
    }
}
