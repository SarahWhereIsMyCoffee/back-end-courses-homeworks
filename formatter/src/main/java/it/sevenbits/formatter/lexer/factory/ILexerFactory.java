package it.sevenbits.formatter.lexer.factory;

import it.sevenbits.formatter.io.reader.IReader;
import it.sevenbits.formatter.lexer.statemachine.ILexer;
import java.lang.reflect.InvocationTargetException;

/**
 * And interface whose implementations will generate ILexer instances.
 */

public interface ILexerFactory {
    /**
     * Method that creates an instance of ILexer interface implementation
     * in accordance with passed IReader implementation.
     *
     * @param reader Instance of IReader which is used for creating for ILexer implementation.
     * @return new ILexer implementation.
     * @throws LexerFactoryException Exception that can be thrown during the method work.
     * @throws IllegalAccessException Exception that can be thrown during the method work.
     * @throws InvocationTargetException Exception that can be thrown during the method work.
     * @throws InstantiationException Exception that can be thrown during the method work.
     */

    ILexer createLexer(final IReader reader) throws IllegalAccessException,
            InvocationTargetException,
            InstantiationException,
            LexerFactoryException;
}
