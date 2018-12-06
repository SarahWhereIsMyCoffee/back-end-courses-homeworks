package it.sevenbits.formatter;

import it.sevenbits.formatter.formatter.Formatter;
import it.sevenbits.formatter.formatter.FormatterException;
import it.sevenbits.formatter.formatter.IFormatter;
import it.sevenbits.formatter.io.reader.FileReader;
import it.sevenbits.formatter.io.reader.IReader;
import it.sevenbits.formatter.io.reader.ReaderException;
import it.sevenbits.formatter.io.writer.IWriter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * With FormatterTest we can test our program. It contains 1 @before method to initialize formatter instance
 * and 2 tests with different examples of code.
 */
public class FormatterTest {
    private IFormatter formatter;
    private IReader reader;
    private IWriter writer;

    @Before
    public void setUp() {
        formatter = new Formatter();
    }

    @Test
    public void shouldFormatCorrectlyAtFirst() throws FormatterException {
        try {
            reader = new FileReader("../formatter/src/test/resources/inputTextes/Text1.txt");
        } catch (ReaderException e) {
            e.printStackTrace();
        }

        String string = formatter.format(reader, writer);
        Assert.assertEquals(string, "{\n" +
                "    {\n" +
                "        something;\n" +
                "    }\n" +
                "}\n");
    }

    @Test
    public void shouldFormatCorrectlyAtSecond() throws FormatterException {
        try {
            reader = new FileReader("../formatter/src/test/resources/inputTextes/Text2.txt");
        } catch (ReaderException e) {
            e.printStackTrace();
        }

        String string = formatter.format(reader, writer);
        Assert.assertEquals(string, "{\n" +
                "    {\n" +
                "        {\n" +
                "        }\n" +
                "    }\n" +
                "}");
    }
}
