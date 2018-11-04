package it.sevenbits.formatter;

import java.io.IOException;

public class Formatter {

    private static final Character SYMBOL_NEW_LINE = '\n';
    private static final Character SYMBOL_OPEN_BRACKET = '{';
    private static final Character SYMBOL_CLOSED_BRACKET = '}';
    private static final Character SYMBOL_SEMICOLON = ';';
    private static final Character SYMBOL_SPACE = ' ';

    public void format(StringReader reader, StringWriter writer) throws IOException {
        int nestingLevel = 0;
        char lastWrittenChar = 0;
        char currentChar = 0;
        char previousReadChar = 0;
        while (reader.hasNext()) {
            previousReadChar = lastWrittenChar;
            currentChar = (char) reader.read();

            if (currentChar == SYMBOL_CLOSED_BRACKET) {
                nestingLevel--;
            }

            if (currentChar == SYMBOL_OPEN_BRACKET) {
                nestingLevel++;
                if (previousReadChar != SYMBOL_SPACE && lastWrittenChar != 0) {
                    writer.write(SYMBOL_SPACE);
                }
                writer.write(currentChar + SYMBOL_NEW_LINE.toString());
                lastWrittenChar = SYMBOL_NEW_LINE;

            } else if (currentChar == SYMBOL_SEMICOLON) {
                        writer.write(SYMBOL_SEMICOLON);
                        writer.write(SYMBOL_NEW_LINE);
                        lastWrittenChar = SYMBOL_NEW_LINE;
            } else if (currentChar == SYMBOL_CLOSED_BRACKET) {
                if (previousReadChar != SYMBOL_NEW_LINE) {
                    writer.write(SYMBOL_NEW_LINE);
                }
                for (int i = 0; i < 4 * nestingLevel; i++) {
                    writer.write(SYMBOL_SPACE);
                }
                writer.write(SYMBOL_CLOSED_BRACKET.toString() + SYMBOL_NEW_LINE);
                lastWrittenChar = SYMBOL_NEW_LINE;
            } else if (currentChar == SYMBOL_NEW_LINE) {
                continue;
            } else if (currentChar == SYMBOL_SPACE) {
                if (previousReadChar == SYMBOL_NEW_LINE || previousReadChar == SYMBOL_CLOSED_BRACKET
                        || previousReadChar == SYMBOL_OPEN_BRACKET) {
                    continue;
                }
                if (lastWrittenChar == SYMBOL_SPACE)
                    continue;
                else {
                    writer.write(currentChar);
                    lastWrittenChar = currentChar;
                }
            }
            else {
                if (previousReadChar == SYMBOL_NEW_LINE) {
                    for (int i = 0; i < 4 * nestingLevel; i++) {
                        writer.write(SYMBOL_SPACE);
                    }
                }
                writer.write(currentChar);
                lastWrittenChar = currentChar;
            }
        }
    }
}
