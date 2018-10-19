package it.sevenbits;

public class Formatter {
    private final char SYMBOL_NEW_LINE = '\n';
    private final char SYMBOL_OPEN_BRACKET = '{';
    private final char SYMBOL_CLOSED_BRACKET = '}';
    private final char SYMBOL_SEMICOLON = ';';
    private final char SYMBOL_SPACE = ' ';

    public String format(String text) {
        StringBuilder finalText = new StringBuilder();
        char currentChar;
        int nestingLevel = 0;
        for (int iterator = 0; iterator < text.length(); iterator++) {
            currentChar = text.charAt(iterator);
            if (currentChar == SYMBOL_OPEN_BRACKET) {
                nestingLevel++;
                if (!finalText.toString().endsWith("" + SYMBOL_NEW_LINE)) {
                    finalText.append(SYMBOL_SPACE);
                }
                finalText.append(currentChar);
                finalText.append(SYMBOL_NEW_LINE);

            } else if (currentChar == SYMBOL_SEMICOLON) {
                finalText.append(currentChar).append(SYMBOL_NEW_LINE);

            } else if (currentChar == SYMBOL_CLOSED_BRACKET) {
                nestingLevel--;
                if (finalText.toString().endsWith("" + SYMBOL_NEW_LINE)) {
                    for (int i = 0; i < 4*nestingLevel; i++) {
                        finalText.append(SYMBOL_SPACE);
                    }
                }
                finalText.append(currentChar).append(SYMBOL_NEW_LINE);
            } else if (currentChar == SYMBOL_NEW_LINE) {
                continue;
            } else if (currentChar == SYMBOL_SPACE) {
                if (finalText.toString().endsWith("" + SYMBOL_SEMICOLON + SYMBOL_NEW_LINE)) {
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
                if (finalText.toString().endsWith("" + SYMBOL_NEW_LINE)) {
                    for (int i = 0; i < 4*nestingLevel; i++) {
                        finalText.append(SYMBOL_SPACE);
                    }
                }
                finalText.append(currentChar);
            }
        }
        return finalText.toString();
    }
}
