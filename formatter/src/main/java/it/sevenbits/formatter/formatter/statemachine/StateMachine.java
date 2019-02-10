package it.sevenbits.formatter.formatter.statemachine;

import it.sevenbits.formatter.formatter.command.util.FormatterCommandArgs;
import it.sevenbits.formatter.formatter.command.commands.IFormatterCommand;
import it.sevenbits.formatter.formatter.command.factory.FormatterCommandFactory;
import it.sevenbits.formatter.io.reader.IReader;
import it.sevenbits.formatter.io.writer.IWriter;
import it.sevenbits.formatter.lexer.statemachine.ILexer;
import it.sevenbits.formatter.lexer.statemachine.LexerException;
import it.sevenbits.formatter.lexer.Token.IToken;
import it.sevenbits.formatter.lexer.factory.LexerFactory;
import it.sevenbits.formatter.lexer.factory.LexerFactoryException;

/**
 * IFormatter implementation that makes it able to format code by
 * analysis of passing lexemes.
 */
public class StateMachine implements IFormatter {
    private LexerFactory lexerFactory;
    private StateTransition stateTransition;
    private FormatterCommandFactory formatterCommandFactory;
    private FormatterState currentState;
    private FormatterCommandArgs formatterCommandArgs;
    private static final Character SYMBOL_OPENING_BRACKET = '{';
    private static final Character SYMBOL_CLOSING_BRACKET = '}';

    /**
     * This method works on SM.
     * It takes a symbol from reader, then takes a necessary state,
     * after it calls a commands according with new state and last written lexeme.
     *
     * @param reader - IReader instance for getting string.
     * @param writer - IWriter instance for writing formatted string.
     * @return String - text of formatted code
     * @throws FormatterException Exception that can be thrown during the method work.
     */
    @Override
    public String format(final IReader reader, final IWriter writer) throws FormatterException {
        formatterCommandArgs = new FormatterCommandArgs(writer);
        formatterCommandFactory = new FormatterCommandFactory(formatterCommandArgs);
        stateTransition = new StateTransition();
        lexerFactory = new LexerFactory();
        currentState = stateTransition.getStartState();

        formatterCommandArgs.setLastWrittenLexemeName("");
        formatterCommandArgs.setLastWrittenLexeme("");

        IFormatterCommand currentCommand;
        IToken currentToken = null;
        StringBuilder stringBuilder = new StringBuilder();
        ILexer lexer;
        try {
            lexer = lexerFactory.createLexer(reader);
        } catch (LexerFactoryException e) {
            throw new FormatterException("EXCEPTION: Unable to create a lexer", e);
        }

        while (lexer.hasNextToken()) {
            try {
                currentToken = lexer.readToken();
            } catch (LexerException e) {
                e.printStackTrace();
            }
            currentState = stateTransition.nextState(currentToken.getName());
            formatterCommandArgs.setCurrentLexeme(currentToken.getLexeme());
            formatterCommandArgs.setCurrentLexemeName(currentToken.getName());
            System.out.println("1. " + currentToken.getLexeme() + " " + formatterCommandArgs.getCurrentLexemeName());

            if (currentToken.getLexeme().equals(SYMBOL_CLOSING_BRACKET.toString())) {
                formatterCommandArgs.decrementNestingLevel();
            }

            stringBuilder.append(formatterCommandArgs.getCurrentLexeme());
            currentCommand = formatterCommandFactory.createCommand(formatterCommandArgs.getLastWrittenLexemeName(), currentState);
            currentCommand.execute();

            if (currentToken.getLexeme().equals(SYMBOL_OPENING_BRACKET.toString())) {
                formatterCommandArgs.incrementNestingLevel();
            }
        }
        return stringBuilder.toString();
    }
}
