package it.sevenbits.formatter.lexer.lexerfactory;

import it.sevenbits.formatter.io.reader.IReader;
import it.sevenbits.formatter.lexer.ILexer;

import java.lang.reflect.InvocationTargetException;

public interface ILexerFactory {
    ILexer createLexer(IReader reader) throws IllegalAccessException,
            InvocationTargetException,
            InstantiationException,
            LexerFactoryException;
}
