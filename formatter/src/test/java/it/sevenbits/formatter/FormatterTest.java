package it.sevenbits.formatter;

import it.sevenbits.formatter.reader.IReader;
import it.sevenbits.formatter.reader.instance.StringReader;
import it.sevenbits.formatter.writer.IWriter;
import it.sevenbits.formatter.writer.instance.StringWriter;
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
        InputStream fileStream = new FileInputStream(new File("src/test/resources/TextsForFormatting/Test1Code.txt"));
        Reader fileReader = new InputStreamReader(fileStream, StandardCharsets.UTF_8);
        int intValueOfChar;
        StringBuilder stringBuilder = new StringBuilder();
        while ((intValueOfChar = fileReader.read()) != -1) {
            stringBuilder.append((char) intValueOfChar);
        }
        fileStream.close();
        fileReader.close();
        String textToFormat = stringBuilder.toString();

        fileStream = new FileInputStream(new File("src/test/resources/TextsShouldBeAfterFormatting/Test1CodeFormatted.txt"));
        fileReader = new InputStreamReader(fileStream, StandardCharsets.UTF_8);
        stringBuilder = new StringBuilder();
        while ((intValueOfChar = fileReader.read()) != -1) {
            stringBuilder.append((char) intValueOfChar);
        }

        fileReader.close();
        String textShouldBe = stringBuilder.toString();

        IReader stringReader = new it.sevenbits.formatter.reader.instance.StringReader(textToFormat);
        IWriter stringWriter = new it.sevenbits.formatter.writer.instance.StringWriter();
        formatter.format(stringReader, stringWriter);
        String formattedText = stringWriter.toString();

        fileStream.close();
        fileReader.close();
        assertEquals(formattedText, textShouldBe);
    }
    @Test
    public void Test2() throws IOException {
        InputStream fileStream = new FileInputStream(new File("src/test/resources/TextsForFormatting/Test2Code.txt"));
        Reader fileReader = new InputStreamReader(fileStream, StandardCharsets.UTF_8);
        int intValueOfChar;
        StringBuilder stringBuilder = new StringBuilder();
        while ((intValueOfChar = fileReader.read()) != -1) {
            stringBuilder.append((char) intValueOfChar);
        }
        String textToFormat = stringBuilder.toString();

        fileStream = new FileInputStream(new File("src/test/resources/TextsShouldBeAfterFormatting/Test2CodeFormatted.txt"));
        fileReader = new InputStreamReader(fileStream, StandardCharsets.UTF_8);
        stringBuilder = new StringBuilder();
        while ((intValueOfChar = fileReader.read()) != -1) {
            stringBuilder.append((char) intValueOfChar);
        }
        String textShouldBe = stringBuilder.toString();

        IReader stringReader = new it.sevenbits.formatter.reader.instance.StringReader(textToFormat);
        IWriter stringWriter = new it.sevenbits.formatter.writer.instance.StringWriter();
        formatter.format(stringReader, stringWriter);
        String formattedText = stringWriter.toString();

        fileStream.close();
        fileReader.close();
        assertEquals(formattedText, textShouldBe);
    }
    @Test
    public void Test3() throws IOException {
       InputStream fileStream = new FileInputStream(new File("src/test/resources/TextsForFormatting/Test3Code.txt"));
        Reader fileReader = new InputStreamReader(fileStream, StandardCharsets.UTF_8);
        int intValueOfChar;
        StringBuilder stringBuilder = new StringBuilder();
        while ((intValueOfChar = fileReader.read()) != -1) {
            stringBuilder.append((char) intValueOfChar);
        }
        String textToFormat = stringBuilder.toString();

        fileStream = new FileInputStream(new File("src/test/resources/TextsShouldBeAfterFormatting/Test3CodeFormatted.txt"));
        fileReader = new InputStreamReader(fileStream, StandardCharsets.UTF_8);
        stringBuilder = new StringBuilder();
        while ((intValueOfChar = fileReader.read()) != -1) {
            stringBuilder.append((char) intValueOfChar);
        }
        String textShouldBe = stringBuilder.toString();

        IReader stringReader = new StringReader(textToFormat);
        IWriter stringWriter = new StringWriter();
        formatter.format(stringReader, stringWriter);
        String formattedText = stringWriter.toString();

        fileStream.close();
        fileReader.close();
        assertEquals(formattedText, textShouldBe);
    }
}
