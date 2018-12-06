package it.sevenbits.formatter.formatter;

import it.sevenbits.formatter.lexer.Token.Token;
import it.sevenbits.formatter.io.reader.IReader;
import it.sevenbits.formatter.io.writer.IWriter;
import it.sevenbits.formatter.lexer.ILexer;
import it.sevenbits.formatter.lexer.lexerfactory.LexerFactory;
import it.sevenbits.formatter.lexer.lexerfactory.LexerFactoryException;

/**
 *
 */
public class Formatter implements IFormatter {
    private LexerFactory lexerFactory;

    private static final Character SYMBOL_NEW_LINE = '\n';
    private static final Character SYMBOL_OPENING_BRACKET = '{';
    private static final Character SYMBOL_CLOSING_BRACKET = '}';
    private static final Character SYMBOL_SEMICOLON = ';';
    private static final Character SYMBOL_SPACE = ' ';
    private static final String SYMBOL_INDENTION = "    ";

    private static final String LEXEME_NAME_DEFAULT = "DEFAULT_LEXEME";
    private static final String LEXEME_NAME_SPACE = "SYMBOL_SPACE";
    private static final String LEXEME_NAME_SEMICOLON = "SYMBOL_SEMICOLON";
    private static final String LEXEME_NAME_NEW_LINE = "SYMBOL_NEW_LINE";
    private static final String LEXEME_NAME_OPENING_BRACKET = "SYMBOL_OPENING_BRACKET";
    private static final String LEXEME_NAME_CLOSING_BRACKET = "SYMBOL_CLOSING_BRACKET";

    @Override
    public String format(final IReader reader, final IWriter writer) throws FormatterException {
        lexerFactory = new LexerFactory();
        ILexer lexer;
        try {
            lexer = lexerFactory.createLexer(reader);
        } catch (LexerFactoryException e) {
            throw new FormatterException("ALO", e);
        }

        Token currentToken;
        StringBuilder stringBuilder = new StringBuilder();
        int nestingLevel = 0;

        while (lexer.hasNextToken()) {
            currentToken = lexer.readToken();
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
                stringBuilder.append(currentToken.getLexeme());
            }
        }

        return stringBuilder.toString();
    }
}
