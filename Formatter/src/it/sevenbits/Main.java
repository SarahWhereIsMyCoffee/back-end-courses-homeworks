package it.sevenbits;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String text = getTextFromFile(args[0]);
        Formatter formatter = new Formatter();

        text = formatter.format(text);
        System.out.println("\n" + text);
    }

    public static String getTextFromFile(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        StringBuilder stringBuilder = new StringBuilder();

        int character = bufferedReader.read();
        while (character != -1) {
            stringBuilder.append((char)character);
            character = bufferedReader.read();
        }

        return stringBuilder.toString();
    }
}
