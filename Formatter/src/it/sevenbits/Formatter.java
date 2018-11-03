package it.sevenbits;

public class Formatter {
    private static final Character SYMBOL_NEW_LINE = '\n';
    private static final Character SYMBOL_OPEN_BRACKET = '{';
    private static final Character SYMBOL_CLOSED_BRACKET = '}';
    private static final Character SYMBOL_SEMICOLON = ';';
    private static final Character SYMBOL_SPACE = ' ';

    public String format(String text) {
        StringBuilder finalText = new StringBuilder();
        char currentChar;
        int nestingLevel = 0;

        for (int iterator = 0; iterator < text.length(); iterator++) {
            currentChar = text.charAt(iterator);

            if (currentChar == SYMBOL_CLOSED_BRACKET) {
                nestingLevel--;
            }

            if (finalText.toString().endsWith(SYMBOL_NEW_LINE.toString()) && currentChar != SYMBOL_SPACE && currentChar!= SYMBOL_NEW_LINE) {
                for (int i = 0; i < 4 * nestingLevel; i++) {
                    finalText.append(' ');
                }
            }

            if (currentChar == SYMBOL_OPEN_BRACKET) {
                nestingLevel++;
                if (!finalText.toString().endsWith(SYMBOL_SPACE.toString()) && finalText.length() != 0) {
                    finalText.append(SYMBOL_SPACE);
                }
                finalText.append(currentChar);
                finalText.append(SYMBOL_NEW_LINE);

            } else if (currentChar == SYMBOL_SEMICOLON) {
                finalText.append(currentChar).append(SYMBOL_NEW_LINE);
            } else if (currentChar == SYMBOL_CLOSED_BRACKET) {
                if (!finalText.toString().endsWith(SYMBOL_NEW_LINE.toString()) && !finalText.toString().endsWith(SYMBOL_SPACE.toString())) {
                    finalText.append(SYMBOL_NEW_LINE);
                    for (int i = 0; i < 4 * nestingLevel; i++) {
                        finalText.append(' ');
                    }
                }
                    finalText.append(currentChar).append(SYMBOL_NEW_LINE);
            } else if (currentChar == SYMBOL_NEW_LINE) {
                continue;
            } else if (currentChar == SYMBOL_SPACE) {
                if (finalText.toString().endsWith(SYMBOL_SEMICOLON.toString() + SYMBOL_NEW_LINE.toString()) ||
                        finalText.toString().endsWith(SYMBOL_CLOSED_BRACKET.toString()) ||
                        finalText.toString().endsWith(SYMBOL_OPEN_BRACKET.toString() + SYMBOL_NEW_LINE)) {
                    continue;
                } else {
                    finalText.append(currentChar);
                    while (iterator < text.length() && currentChar == SYMBOL_SPACE) {
                        iterator++;
                        currentChar = text.charAt(iterator);
                    }
                    iterator--;
                }
            }
            else {
                finalText.append(currentChar);
            }
        }
        return finalText.toString();
    }
}
