package it.sevenbits.formatter.io.writer;

import it.sevenbits.formatter.io.writer.IWriter;

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

    @Override
    public void write(char character) throws IOException {
        writer.write(character);
    }

    @Override
    public void write(String string) throws IOException {
        writer.write(string);
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
