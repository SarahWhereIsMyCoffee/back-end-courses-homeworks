package it.sevenbits.formatter.io.reader;

import it.sevenbits.formatter.io.reader.IReader;
import it.sevenbits.formatter.io.reader.ReaderException;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileReader implements IReader, Closeable {
    private Reader reader;

    public FileReader(final String filePath) throws ReaderException {
        final File inputFile = new File(filePath);
        try {
            reader = new InputStreamReader(
                    new BufferedInputStream(new FileInputStream(inputFile)),
                    StandardCharsets.UTF_8
            );
        } catch (FileNotFoundException e) {
            throw new ReaderException("Unable to open stream");
        }
    }

    @Override
    public boolean hasNext() {
        return reader != null;
    }

    @Override
    public int read() throws IOException {
        if (reader == null) {
            throw new ReaderException("Stream is closed");
        }
        int currentChar = 0;

        if (hasNext()) {
            currentChar = reader.read();
        }
        return currentChar;
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
