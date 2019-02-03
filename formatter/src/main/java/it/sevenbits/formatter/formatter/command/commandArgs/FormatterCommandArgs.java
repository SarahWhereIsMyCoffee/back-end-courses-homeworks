package it.sevenbits.formatter.formatter.command.commandArgs;

import it.sevenbits.formatter.io.writer.IWriter;

public class FormatterCommandArgs {
    private int nestingLevel;
    private IWriter writer;
    private String currentLexeme;
    private String lastWrittenLexeme = "";

    public FormatterCommandArgs(IWriter writer) {
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

    public void setNestingLevel(int nestingLevel) {
        this.nestingLevel = nestingLevel;
    }

    public void setWriter(IWriter writer) {
        this.writer = writer;
    }

    public void setCurrentLexeme(String currentLexeme) {
        this.currentLexeme = currentLexeme;
    }

    public void setLastWrittenLexeme(String lastWrittenLexeme) {
        this.lastWrittenLexeme = lastWrittenLexeme;
    }
}
