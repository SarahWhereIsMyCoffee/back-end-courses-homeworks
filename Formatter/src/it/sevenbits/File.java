package it.sevenbits;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class File {
    private String path = "resourses/Textfile.txt";
    private StringBuilder stringBuilder = new StringBuilder();

    public File() {
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            Scanner scanner = new Scanner(in);



            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
            }
        }
        catch (IOException | NumberFormatException e)
        {
            e.printStackTrace();
        }
    }

    public void showStringBuilder() {
        System.out.println(stringBuilder.toString());
    }

    public StringBuilder getStringBuilder() {
        return stringBuilder;
    }

}
