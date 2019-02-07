package it.sevenbits.formatter.lexer.statemachine;

import it.sevenbits.formatter.io.reader.IReader;
import it.sevenbits.formatter.lexer.Token.IToken;
import it.sevenbits.formatter.lexer.Token.TokenBuilder;
import it.sevenbits.formatter.lexer.command.commands.ILexerCommand;
import it.sevenbits.formatter.lexer.command.util.LexerCommandArgs;
import it.sevenbits.formatter.lexer.command.factory.LexerCommandFactory;
import java.io.IOException;

/**
 * ILexer implementation that provides lexical analysis of Java source code.
 */
public class StateMachine implements ILexer {
    private IReader reader;
    private int currentIntChar;

    private LexerCommandArgs lexerCommandArgs;
    private StateTransition stateTransition;
    private LexerCommandFactory lexerCommandFactory;
    private TokenBuilder tokenBuilder;
    private State currentState;
    private ILexerCommand currentCommand;
    private State END_OF_LEXEME_STATE;
    /**
     * Constructor of the StateMachine class.
     *
     * @param reader - IReader instance, where we take a character to build a lexeme.
     */
    public StateMachine(final IReader reader) {
        lexerCommandArgs = new LexerCommandArgs();
        END_OF_LEXEME_STATE = new State("END_OF_LEXEME_STATE");
        tokenBuilder = new TokenBuilder();
        stateTransition = new StateTransition();
        lexerCommandFactory = new LexerCommandFactory(tokenBuilder, lexerCommandArgs);
        currentState = stateTransition.startState();

        this.reader = reader;
        try {
            currentIntChar = this.reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method returns a token to the formatter.
     *
     * @return IToken token.
     */
    @Override
    public IToken readToken() {
        State previousState = null;
        if (!hasNextToken()) {
            return null;
        }

        while (hasNextToken()) {
            lexerCommandArgs.setCharacter((char) currentIntChar);
            previousState = currentState;
            currentState = stateTransition.nextState(currentState, lexerCommandArgs.getCharacter());
            currentCommand = lexerCommandFactory.createCommand(currentState);
            currentCommand.execute();
            if (currentState.toString().equals(END_OF_LEXEME_STATE.toString())) {
                break;
            }
            try {
                currentIntChar = reader.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return tokenBuilder.getToken(previousState);
    }

    /**
     * Method that reports whether single instance is available for reading.
     *
     * @return Boolean value that indicates the result of method work.
     */
    @Override
    public boolean hasNextToken() {
        return currentIntChar != -1;
    }
}
