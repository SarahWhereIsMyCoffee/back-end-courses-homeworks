package it.sevenbits.formatter.formatter;

import it.sevenbits.formatter.io.reader.IReader;
import it.sevenbits.formatter.io.writer.IWriter;

public interface IFormatter {
    String format(final IReader reader, final IWriter writer) throws FormatterException;
}
