package it.sevenbits.formatter;

import it.sevenbits.formatter.formatter.Formatter;
import it.sevenbits.formatter.formatter.FormatterException;
import it.sevenbits.formatter.io.reader.IReader;
import it.sevenbits.formatter.io.reader.StringReader;
import it.sevenbits.formatter.io.writer.IWriter;
import it.sevenbits.formatter.io.writer.StringWriter;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.nio.charset.StandardCharsets;
import static org.junit.Assert.assertEquals;

/**
 * With FormatterTest we can test our program. It contains 1 @before method to initialize formatter instance
 * and 3 tests with different examples of code.
 */
public class FormatterTest {
    private Formatter formatter;
    @Before
    public void setUp() {
        this.formatter = new Formatter();
    }

    @Test
    public void Test1() throws IOException {
        InputStream fileStream = new FileInputStream(new File("src/test/resources/inputTextes/Text.txt"));
        Reader fileReader = new InputStreamReader(fileStream, StandardCharsets.UTF_8);
        int intValueOfChar;
        StringBuilder stringBuilder = new StringBuilder();
        while ((intValueOfChar = fileReader.read()) != -1) {
            stringBuilder.append((char) intValueOfChar);
        }
        fileStream.close();
        fileReader.close();
        String textToFormat = stringBuilder.toString();

        fileStream = new FileInputStream(new File("src/test/resources/textesShouldBeAfterFormatting/Text.txt"));
        fileReader = new InputStreamReader(fileStream, StandardCharsets.UTF_8);
        stringBuilder = new StringBuilder();
        while ((intValueOfChar = fileReader.read()) != -1) {
            stringBuilder.append((char) intValueOfChar);
        }

        fileReader.close();
        String textShouldBe = stringBuilder.toString();

        IReader stringReader = new StringReader(textToFormat);
        IWriter stringWriter = new StringWriter();
        try {
            formatter.format(stringReader, stringWriter);
        } catch (FormatterException e) {
            e.printStackTrace();
        }
        String formattedText = stringWriter.toString();

        fileStream.close();
        fileReader.close();
        assertEquals(formattedText, textShouldBe);
    }
}
