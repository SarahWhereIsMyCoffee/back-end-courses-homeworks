package it.sevenbits.formatter;

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {

        InputStream file = Main.class.getClassLoader().getResourceAsStream("Code.txt");
        assert file != null;
        StringBuilder text = new StringBuilder();
        while (file.available() != 0) {
            text.append((char)file.read());
        }

        StringReader stringReader = new StringReader(text.toString());

        StringBuilder formattedString = new StringBuilder();
        StringWriter stringWriter = new StringWriter(formattedString);

        Formatter formatter = new Formatter();
        formatter.format(stringReader, stringWriter);

        System.out.println(formattedString.toString());
    }
    private Main() {}
}

/*для pom.xml
<configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                    <includes>
                        <include>it/sevenbits/formatter/*Test.java</include>
                    </includes>
                </configuration>
 */