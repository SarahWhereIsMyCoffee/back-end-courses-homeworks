package it.sevenbits.formatter;


import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;

public class FormatterTest {
    private Formatter formatter;
    @Before
    public void setUp() {
        this.formatter = new Formatter();
    }

    @Test
    public void Test1() throws IOException {
        InputStream file = FormatterTest.class.getClassLoader().getResourceAsStream("Test1Code.txt");
        assert file != null;
        StringBuilder text = new StringBuilder();
        while (file.available() != 0) {
            text.append((char)file.read());
        }

        StringReader stringReader = new StringReader(text.toString());
        StringBuilder formattedString = new StringBuilder();
        StringWriter stringWriter = new StringWriter(formattedString);
        formatter.format(stringReader, stringWriter);
    }
    @Test
    public void Test2() throws IOException {
        InputStream file = FormatterTest.class.getClassLoader().getResourceAsStream("Test2Code.txt");
        assert file != null;
        StringBuilder text = new StringBuilder();
        while (file.available() != 0) {
            text.append((char)file.read());
        }

        StringReader stringReader = new StringReader(text.toString());
        StringBuilder formattedString = new StringBuilder();
        StringWriter stringWriter = new StringWriter(formattedString);
        formatter.format(stringReader, stringWriter);
    }
    @Test
    public void Test3() throws IOException {
        InputStream file = FormatterTest.class.getClassLoader().getResourceAsStream("Test3Code.txt");
        assert file != null;
        StringBuilder text = new StringBuilder();
        while (file.available() != 0) {
            text.append((char)file.read());
        }

        StringReader stringReader = new StringReader(text.toString());
        StringBuilder formattedString = new StringBuilder();
        StringWriter stringWriter = new StringWriter(formattedString);
        formatter.format(stringReader, stringWriter);
    }
}
