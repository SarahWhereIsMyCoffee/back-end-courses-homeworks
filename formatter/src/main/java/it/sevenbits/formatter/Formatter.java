package it.sevenbits.formatter;

import it.sevenbits.formatter.reader.IReader;
import it.sevenbits.formatter.writer.IWriter;

import java.io.IOException;

/**
 * Class Formatter contains one method that formats some string code according to Java Style rules
 */
public class Formatter {

    private static final Character SYMBOL_NEW_LINE = '\n';
    private static final Character SYMBOL_OPEN_BRACKET = '{';
    private static final Character SYMBOL_CLOSED_BRACKET = '}';
    private static final Character SYMBOL_SEMICOLON = ';';
    private static final Character SYMBOL_SPACE = ' ';

    /**
     * This method for formats the string according to Java Style rules
     *
     * @param reader reads out string, and then passes it to char variable for the furter work
     * @param writer writes char our string to the string, that StringWriter class contains
     * @throws IOException for the reader.read() error
     */
    public void format(final IReader reader, final IWriter writer) throws IOException {
        int nestingLevel = 0;
        final int countOfSpaces = 4;
        char lastWrittenChar = 0;
        char lastRememberedChar = 0;
        char currentChar;
        boolean quoteIsOpen = false;

        while (reader.hasNext()) {

            currentChar = (char) reader.read();
            if (currentChar == SYMBOL_CLOSED_BRACKET) {
                nestingLevel--;
            }

            if (currentChar == SYMBOL_OPEN_BRACKET) {
                if (lastWrittenChar != SYMBOL_SPACE && lastWrittenChar != 0 && lastWrittenChar != SYMBOL_NEW_LINE) {
                    writer.write(SYMBOL_SPACE);
                }
                /*  Делаю этот цикл, потому что остальным сделали замечание
                    насчёт отступов у открытых скобок.
                    Ведь открытые скобки всегда стоят через пробел от условия, смысл делать им табуляцию О_о
                    Поэтому, хоть я и не согласен с этим, но всё же
                 */
                if (lastWrittenChar == SYMBOL_NEW_LINE) {
                    for (int i = 0; i < countOfSpaces * nestingLevel; i++) {
                        writer.write(SYMBOL_SPACE);
                        }
                }
                nestingLevel++;
                writer.write(currentChar + SYMBOL_NEW_LINE.toString());
                lastWrittenChar = SYMBOL_NEW_LINE;
            } else if (currentChar == SYMBOL_SEMICOLON) {
                        writer.write(SYMBOL_SEMICOLON);
                        writer.write(SYMBOL_NEW_LINE);
                        lastWrittenChar = SYMBOL_NEW_LINE;
            } else if (currentChar == SYMBOL_CLOSED_BRACKET) {
                if (lastWrittenChar != SYMBOL_NEW_LINE) {
                    writer.write(SYMBOL_NEW_LINE);
                }
                for (int i = 0; i < countOfSpaces * nestingLevel; i++) {
                    writer.write(SYMBOL_SPACE);
                }
                writer.write(SYMBOL_CLOSED_BRACKET.toString() + SYMBOL_NEW_LINE);
                lastWrittenChar = SYMBOL_NEW_LINE;
            } else if (currentChar == SYMBOL_NEW_LINE) {
                continue;
            } else if (currentChar == SYMBOL_SPACE) {
                if (lastWrittenChar == SYMBOL_NEW_LINE || lastWrittenChar == SYMBOL_CLOSED_BRACKET
                        || lastWrittenChar == SYMBOL_OPEN_BRACKET) {
                    continue;
                }
                if (lastWrittenChar == SYMBOL_SPACE) {
                    continue;
                } else {
                    writer.write(currentChar);
                    lastWrittenChar = currentChar;
                }
            } else {
                if (lastWrittenChar == SYMBOL_NEW_LINE) {
                    for (int i = 0; i < countOfSpaces * nestingLevel; i++) {
                        writer.write(SYMBOL_SPACE);
                    }
                }
                writer.write(currentChar);
                lastWrittenChar = currentChar;
            }
        }
    }
}
