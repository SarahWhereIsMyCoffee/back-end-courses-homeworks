package it.sevenbits.formatter.formatter.statemachine;

import it.sevenbits.formatter.commonFormatter.FormatterException;
import it.sevenbits.formatter.commonFormatter.IFormatter;
import it.sevenbits.formatter.formatter.command.commandArgs.FormatterCommandArgs;
import it.sevenbits.formatter.formatter.command.commands.IFormatterCommand;
import it.sevenbits.formatter.formatter.command.factory.FormatterCommandFactory;
import it.sevenbits.formatter.io.reader.IReader;
import it.sevenbits.formatter.io.writer.IWriter;
import it.sevenbits.formatter.lexer.ILexer;
import it.sevenbits.formatter.lexer.LexerException;
import it.sevenbits.formatter.lexer.Token.Token;
import it.sevenbits.formatter.lexer.lexerfactory.LexerFactory;
import it.sevenbits.formatter.lexer.lexerfactory.LexerFactoryException;

public class FormatterStateMachine implements IFormatter {
    private LexerFactory lexerFactory;
    private FormatterStateTransition formatterStateTransition;
    private FormatterCommandFactory formatterCommandFactory;
    private FormatterState currentState;
    private FormatterCommandArgs formatterCommandArgs;
    private String LEXEME_OPENING_BRACKET_NAME = "LEXEME_OPENING_CURLY_BRACKET";
    private String LEXEME_CLOSING_BRACKET_NAME = "LEXEME_CLOSING_CURLY_BRACKET";

    public FormatterStateMachine() {

    }

    @Override
    public String format(IReader reader, IWriter writer) throws FormatterException {
        formatterCommandArgs = new FormatterCommandArgs(writer);
        formatterCommandFactory = new FormatterCommandFactory(formatterCommandArgs);
        formatterStateTransition = new FormatterStateTransition();
        currentState = formatterStateTransition.getStartState();
        lexerFactory = new LexerFactory();

        IFormatterCommand currentCommand;
        Token currentToken = null;
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
            if (currentToken.getName() == LEXEME_CLOSING_BRACKET_NAME) {
                formatterCommandArgs.decrementNestingLevel();
            }
            stringBuilder.append(formatterCommandArgs.getCurrentLexeme());
            currentState = formatterStateTransition.nextState(currentState, currentToken.getName());
            currentCommand = formatterCommandFactory.createCommand(currentState);
            currentCommand.execute();
            if (currentToken.getName() == LEXEME_OPENING_BRACKET_NAME) {
                formatterCommandArgs.incrementNestingLevel();
            }
        }
        return stringBuilder.toString();
    }
}
