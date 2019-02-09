package it.sevenbits.formatter.formatter.command.util;

import it.sevenbits.formatter.io.writer.IWriter;

/**
 * This class is a container for providing some instances we need during the program
 */
public class FormatterCommandArgs {
    private int nestingLevel;
    private IWriter writer;

    private String currentLexeme;
    private String currentLexemeName;

    private String lastWrittenLexeme;
    private String lastWrittenLexemeName;

    /**
     * This method sets a name of the last written lexeme.
     * @param currentLexemeName String last written lexeme.
     */
    public void setCurrentLexemeName(String currentLexemeName) {
        this.currentLexemeName = currentLexemeName;
    }

    /**
     * This method returns the name of last written lexeme contained in FormatterCommandArgs instance.
     *
     * @return String last written.
     */
    public String getCurrentLexemeName() {
        return currentLexemeName;
    }

    /**
     * This method returns the last written lexeme contained in FormatterCommandArgs instance.
     *
     * @return String last written.
     */
    public String getLastWrittenLexemeName() {
        return lastWrittenLexemeName;
    }

    /**
     * This method sets last written lexeme.
     * @param lastWrittenLexemeName String last written lexeme.
     */
    public void setLastWrittenLexemeName(String lastWrittenLexemeName) {
        this.lastWrittenLexemeName = lastWrittenLexemeName;
    }

    /**
     * Constructor of FormatterCommandArgs class.
     * He we declare the IWriter instance.
     *
     * @param writer IWriter instance.
     */
    public FormatterCommandArgs(final IWriter writer) {
        this.writer = writer;
    }

    /**
     * The method returns value of nesting level.
     *
     * @return Int value of nesting level
     */
    public int getNestingLevel() {
        return nestingLevel;
    }

    /**
     * The method increments value of nesting level.
     */
    public void incrementNestingLevel() {
        nestingLevel++;
    }
    /**
     * The method decrements value of nesting level.
     */
    public void decrementNestingLevel() {
        nestingLevel--;
    }

    /**
     * The method returns declared IWriter instance.
     *
     * @return IWriter instance.
     */
    public IWriter getWriter() {
        return writer;
    }

    /**
     * This method returns a current lexeme contained in FormatterCommandArgs instance.
     *
     * @return String current lexeme.
     */
    public String getCurrentLexeme() {
        return currentLexeme;
    }

    /**
     * This method returns the last written lexeme contained in FormatterCommandArgs instance.
     *
     * @return String last written.
     */
    public String getLastWrittenLexeme() {
        return lastWrittenLexeme;
    }

    /**
     * This method sets current lexeme.
     * @param currentLexeme String current lexeme.
     */
    public void setCurrentLexeme(final String currentLexeme) {
        this.currentLexeme = currentLexeme;
    }

    /**
     * This method sets last written lexeme.
     * @param lastWrittenLexeme String last written lexeme.
     */
    public void setLastWrittenLexeme(final String lastWrittenLexeme) {
        this.lastWrittenLexeme = lastWrittenLexeme;
    }
}
