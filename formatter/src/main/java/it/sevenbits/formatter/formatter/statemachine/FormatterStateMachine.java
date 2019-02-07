package it.sevenbits.formatter.formatter.statemachine;

import it.sevenbits.formatter.formatter.command.commandargs.FormatterCommandArgs;
import it.sevenbits.formatter.formatter.command.commands.IFormatterCommand;
import it.sevenbits.formatter.formatter.command.factory.FormatterCommandFactory;
import it.sevenbits.formatter.io.reader.IReader;
import it.sevenbits.formatter.io.writer.IWriter;
import it.sevenbits.formatter.lexer.statemachine.ILexer;
import it.sevenbits.formatter.lexer.statemachine.LexerException;
import it.sevenbits.formatter.lexer.Token.IToken;
import it.sevenbits.formatter.lexer.lexerfactory.LexerFactory;
import it.sevenbits.formatter.lexer.lexerfactory.LexerFactoryException;

public class FormatterStateMachine implements IFormatter {
    private LexerFactory lexerFactory;
    private FormatterStateTransition formatterStateTransition;
    private FormatterCommandFactory formatterCommandFactory;
    private FormatterState currentState;
    private FormatterCommandArgs formatterCommandArgs;
    private Character SYMBOL_OPENING_BRACKET = '{';
    private Character SYMBOL_CLOSING_BRACKET = '}';

    public FormatterStateMachine() {

    }

    @Override
    public String format(IReader reader, IWriter writer) throws FormatterException {
        formatterCommandArgs = new FormatterCommandArgs(writer);
        formatterCommandFactory = new FormatterCommandFactory(formatterCommandArgs);
        formatterStateTransition = new FormatterStateTransition();
        currentState = formatterStateTransition.getStartState();
        FormatterState previousState = formatterStateTransition.getStartState();
        lexerFactory = new LexerFactory();

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
            formatterCommandArgs.setCurrentLexeme(currentToken.getLexeme());
            if (currentToken.getLexeme().equals(SYMBOL_CLOSING_BRACKET.toString())) {
                formatterCommandArgs.decrementNestingLevel();
            }
            stringBuilder.append(formatterCommandArgs.getCurrentLexeme());
            currentState = formatterStateTransition.nextState(currentToken.getName());
            currentCommand = formatterCommandFactory.createCommand(previousState, currentState);
            System.out.println("CURRENT TOKEN IN FORMATTER: " + currentToken.getName() + " " + currentToken.getLexeme());
            currentCommand.execute();
            if (currentToken.getLexeme().equals(SYMBOL_OPENING_BRACKET.toString())) {
                formatterCommandArgs.incrementNestingLevel();
            }
            previousState = currentState;
        }
        return stringBuilder.toString();
    }
}
