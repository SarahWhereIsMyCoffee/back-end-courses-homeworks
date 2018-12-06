package it.sevenbits.formatter.io.reader;

import java.io.Closeable;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Class FileReader reads text from the specified file for the formatting.
 */
public class FileReader implements IReader, Closeable {
    private Reader reader;

    /**
     * Constructor of FileReader class
     * @param filePath - String; path of the file, where we getting text.
     * @throws ReaderException - Exception that can be thrown during the method work.
     */
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

    /**
     * Method to check, if reader has next character
     * @return - returns boolean: true if it has, false in different case.
     */
    @Override
    public boolean hasNext() {
        return reader != null;
    }

    /**
     * Method to get next character.
     * @return - next character
     * @throws IOException - Exception that can be thrown during the method work.
     */
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

    /**
     * Method for the closing of stream.
     * @throws IOException - Exception that can be thrown during the method work.
     */
    @Override
    public void close() throws IOException {
        reader.close();
    }
}
