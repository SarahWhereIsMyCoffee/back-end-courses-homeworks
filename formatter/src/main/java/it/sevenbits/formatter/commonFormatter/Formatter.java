package it.sevenbits.formatter.commonFormatter;

import it.sevenbits.formatter.lexer.Token.Token;
import it.sevenbits.formatter.io.reader.IReader;
import it.sevenbits.formatter.io.writer.IWriter;
import it.sevenbits.formatter.lexer.ILexer;
import it.sevenbits.formatter.lexer.lexerfactory.LexerFactory;
import it.sevenbits.formatter.lexer.lexerfactory.LexerFactoryException;

import java.io.IOException;

/**
 * This method formats inputting string by taking lexemes and exposing the desired characters between them.
 */
public class Formatter implements IFormatter {
    private LexerFactory lexerFactory;

    private static final Character SYMBOL_NEW_LINE = '\n';
    private static final Character SYMBOL_SPACE = ' ';
    private static final String SYMBOL_INDENTION = "    ";

    private static final String LEXEME_NAME_SPACE = "SYMBOL_SPACE";
    private static final String LEXEME_NAME_SEMICOLON = " ";
    private static final String LEXEME_NAME_NEW_LINE = "SYMBOL_NEW_LINE";
    private static final String LEXEME_NAME_OPENING_BRACKET = "SYMBOL_OPENING_BRACKET";
    private static final String LEXEME_NAME_CLOSING_BRACKET = "SYMBOL_CLOSING_BRACKET";



    /**
     * Method that performs formatting of Java source code that is stored in lexical tokens
     * which are provided by ILexer instance.
     * @param reader - IReader instance for getting string.
     * @param writer - IWriter instance for writing formatted string.
     * @return - returned string we got
     * @throws FormatterException - Exception that can be thrown during the method work.
     */
    @Override
    public String format(final IReader reader, final IWriter writer) throws FormatterException {
        lexerFactory = new LexerFactory();
        ILexer lexer;
        try {
            lexer = lexerFactory.createLexer(reader);
        } catch (LexerFactoryException e) {
            throw new FormatterException("ALO", e);
        }

        Token currentToken = null;
        StringBuilder stringBuilder = new StringBuilder();
        Integer nestingLevel = 0;
/*
        while (lexer.hasNextToken()) {
            try {
                currentToken = lexer.readToken();
            } catch (LexerException e) {
                e.printStackTrace();
            }

            if (currentToken.getName().equals(LEXEME_NAME_NEW_LINE)
                    || (currentToken.getName().equals(LEXEME_NAME_SPACE) &&
                        stringBuilder.toString().endsWith(SYMBOL_NEW_LINE.toString()))) {
                continue;
            }

            if (stringBuilder.toString().endsWith(SYMBOL_NEW_LINE.toString())) {
                if (currentToken.getName().equals(LEXEME_NAME_CLOSING_BRACKET)) {
                    nestingLevel--;
                }

                for (int i = 0; i < nestingLevel; i++) {
                    stringBuilder.append(SYMBOL_INDENTION);
                }
            }
            if (currentToken.getName().equals(LEXEME_NAME_OPENING_BRACKET)) {
                nestingLevel++;
                if (!stringBuilder.toString().endsWith(SYMBOL_SPACE.toString()) && stringBuilder.length() != 0) {
                    stringBuilder.append(SYMBOL_SPACE);
                }
                stringBuilder.append(currentToken.getLexeme()).append(SYMBOL_NEW_LINE);
            } else if (currentToken.getName().equals(LEXEME_NAME_CLOSING_BRACKET)) {
                if (!stringBuilder.toString().endsWith(SYMBOL_NEW_LINE.toString())
                        && !stringBuilder.toString().endsWith(SYMBOL_SPACE.toString())) {
                    stringBuilder.append(SYMBOL_NEW_LINE);
                }
                stringBuilder.append(currentToken.getLexeme()).append(SYMBOL_NEW_LINE);
            } else if (currentToken.getName().equals(LEXEME_NAME_SEMICOLON)) {
                if (stringBuilder.toString().endsWith(SYMBOL_SPACE.toString())) {
                    stringBuilder.setLength(stringBuilder.length() - 1);
                }
                stringBuilder.append(currentToken.getLexeme()).append(SYMBOL_NEW_LINE);
            } else {
                if (!(currentToken.getName().equals(LEXEME_NAME_SPACE) &&
                        stringBuilder.toString().endsWith(SYMBOL_SPACE.toString()))) {
                    stringBuilder.append(currentToken.getLexeme());
                }
            }
        }

        try {
            writer.write(stringBuilder.toString());
        } catch (IOException e) {
            throw new FormatterException("Unable to write");
        }
        */
        return stringBuilder.toString();
    }
}
