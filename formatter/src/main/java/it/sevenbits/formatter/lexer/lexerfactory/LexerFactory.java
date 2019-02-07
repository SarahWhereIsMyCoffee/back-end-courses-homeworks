package it.sevenbits.formatter.lexer.lexerfactory;

import it.sevenbits.formatter.io.reader.IReader;
import it.sevenbits.formatter.io.reader.FileReader;
import it.sevenbits.formatter.io.reader.StringReader;
import it.sevenbits.formatter.lexer.statemachine.ILexer;
import it.sevenbits.formatter.lexer.statemachine.LexerStateMachine;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class LexerFactory implements ILexerFactory {
    private final Map<Class<? extends IReader>, Class<? extends ILexer>> iReaderMap;
    public LexerFactory() {
        iReaderMap = new HashMap<>();
        iReaderMap.put(StringReader.class, LexerStateMachine.class);
        iReaderMap.put(FileReader.class, LexerStateMachine.class);
    }

    @Override
    public ILexer createLexer(final IReader reader) throws LexerFactoryException {
        if (reader == null) {
            throw new LexerFactoryException("Null passed as argument");
        }

        final Class<? extends ILexer> lexerClass = iReaderMap.get(reader.getClass());

        if (lexerClass == null) {
            throw new LexerFactoryException("There are no ILexer interface implementations that " +
                    "match the passed IReader interface implementation");
        }

        Constructor<? extends ILexer> lexerConstructor;
        try {
            lexerConstructor = lexerClass.getDeclaredConstructor(IReader.class);
        } catch (NoSuchMethodException e) {
            throw new LexerFactoryException("Invoked " + lexerClass.getSimpleName() +
                    " constructor does not exist", e);
        }

        try {
            return lexerConstructor.newInstance(reader);
        } catch (InvocationTargetException e) {
            throw new LexerFactoryException("An exception was thrown during the creation of " +
                    lexerClass.getSimpleName() + " instance", e.getCause());
        } catch (InstantiationException e) {
            throw new LexerFactoryException("Unable to create " + lexerClass.getSimpleName() + " instance", e);
        } catch (IllegalAccessException e) {
            throw new LexerFactoryException("No access to the definition of " + lexerClass.getSimpleName() +
                    " implementation or constructor", e);
        }
    }
}
