package it.sevenbits.formatter.io.writer;

import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.io.Writer;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriter implements IWriter, Closeable {
    private Writer writer;

    public FileWriter(final String filePath) throws WriterException {
        try {
            writer = new OutputStreamWriter(
                    new BufferedOutputStream(new FileOutputStream(filePath)),
                    StandardCharsets.UTF_8
            );
        } catch (FileNotFoundException e) {
            throw new WriterException("Unable to open stream", e);
        }
    }

    /**
     * Method for the writing a symbol to file.
     * @param character - symbol we append to the line
     * @throws IOException
     */
    @Override
    public void write(final char character) throws IOException {
        writer.write(character);
    }

    /**
     *Method for the writing a string to file.
     * @param string - string we append to the line
     * @throws IOException - Exception that can be thrown during the method work.
     */
    @Override
    public void write(final String string) throws IOException {
        writer.write(string);
    }

    /**
     * Method for closing the stream.
     * @throws IOException -  Exception that can be thrown during the method work.
     */
    @Override
    public void close() throws IOException {
        writer.close();
    }
}
