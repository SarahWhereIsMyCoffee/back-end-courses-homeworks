package it.sevenbits.formatter.formatter.command.util;

import it.sevenbits.formatter.io.writer.IWriter;

/**
 * This class is a container for providing some instances we need during the program
 */
public class FormatterCommandArgs {
    private int nestingLevel;
    private IWriter writer;
    private String currentLexeme;
    private String lastWrittenLexeme = "";

    public FormatterCommandArgs(final IWriter writer) {
        this.writer = writer;
    }
    public int getNestingLevel() {
        return nestingLevel;
    }

    public void incrementNestingLevel() {
        nestingLevel++;
    }

    public void decrementNestingLevel() {
        nestingLevel--;
    }

    public IWriter getWriter() {
        return writer;
    }

    public String getCurrentLexeme() {
        return currentLexeme;
    }

    public String getLastWrittenLexeme() {
        return lastWrittenLexeme;
    }

    public void setCurrentLexeme(final String currentLexeme) {
        this.currentLexeme = currentLexeme;
    }

    public void setLastWrittenLexeme(final String lastWrittenLexeme) {
        this.lastWrittenLexeme = lastWrittenLexeme;
    }
}
