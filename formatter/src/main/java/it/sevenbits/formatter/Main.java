package it.sevenbits.formatter;

import it.sevenbits.formatter.formatter.Formatter;
import it.sevenbits.formatter.formatter.FormatterException;
import it.sevenbits.formatter.io.reader.IReader;
import it.sevenbits.formatter.io.reader.FileReader;
import it.sevenbits.formatter.io.reader.ReaderException;
import it.sevenbits.formatter.io.writer.IWriter;
import it.sevenbits.formatter.io.writer.FileWriter;
import it.sevenbits.formatter.io.writer.WriterException;

/**
 */
public final class Main {
    /**
     * @param args - Command line arguments
     */
    public static void main(final String[] args) {
        Formatter formatter = new Formatter();
        IReader reader = null;
        try {
            reader = new FileReader(args[0]);
        } catch (ReaderException e) {
            e.printStackTrace();
        }
        IWriter writer = null;
        try {
            writer = new FileWriter(args[1]);
        } catch (WriterException e) {
            e.printStackTrace();
        }

        try {
            String formattedText = formatter.format(reader, writer);
            System.out.println(formattedText);
        } catch (FormatterException e) {
            e.printStackTrace();
        }
    }

    private Main() {}
}
