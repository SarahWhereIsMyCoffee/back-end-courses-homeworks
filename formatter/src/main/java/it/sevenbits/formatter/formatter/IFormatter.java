package it.sevenbits.formatter.formatter;

import it.sevenbits.formatter.io.reader.IReader;
import it.sevenbits.formatter.io.writer.IWriter;

/**
 * This is the main class, which makes it able to format the code.
 */
public interface IFormatter {
    /**
     * Main method, which we're using to format the code.
     * @param reader - IReader instance for getting string.
     * @param writer - IWriter instance for writing formatted string.
     * @return - formatted string
     * @throws FormatterException -Exception that can be thrown during the method work.
     */
    String format(final IReader reader, final IWriter writer) throws FormatterException;
}
