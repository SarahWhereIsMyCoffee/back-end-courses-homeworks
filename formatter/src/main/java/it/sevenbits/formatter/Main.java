package it.sevenbits.formatter;

import it.sevenbits.formatter.commonFormatter.Formatter;
import it.sevenbits.formatter.commonFormatter.FormatterException;
import it.sevenbits.formatter.formatter.statemachine.FormatterStateMachine;
import it.sevenbits.formatter.io.reader.IReader;
import it.sevenbits.formatter.io.reader.FileReader;
import it.sevenbits.formatter.io.reader.ReaderException;
import it.sevenbits.formatter.io.writer.IWriter;
import it.sevenbits.formatter.io.writer.FileWriter;
import it.sevenbits.formatter.io.writer.WriterException;

import java.io.IOException;
import java.util.HashMap;

/**
 * Class for the demonstration of formatting.
 */
public final class Main {
    /**
     * @param args - Command line arguments
     */
    public static void main(final String[] args) {
        FormatterStateMachine formatter = new FormatterStateMachine();
        IReader reader = null;
        try {
            reader = new FileReader("../formatter/src/main/resources/inputTexts/Text.txt");
        } catch (ReaderException e) {
            e.printStackTrace();
        }
        IWriter writer = null;
        try {
            writer = new FileWriter("../formatter/src/main/resources/outputTexts/Text.txt");
        } catch (WriterException e) {
            e.printStackTrace();
        }

        try {
            String formattedText = formatter.format(reader, writer);
        } catch (FormatterException e) {
            e.printStackTrace();
        }

        try {
            ((FileWriter) writer).close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private Main() {}
}
