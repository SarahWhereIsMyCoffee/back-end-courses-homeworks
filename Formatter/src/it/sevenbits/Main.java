package it.sevenbits;

public class Main {

    public static void main(String[] args) {

        File file = new File();
        StringBuilder stringBuilder = file.getStringBuilder();

        Formatter formatter = new Formatter(stringBuilder);
        formatter.format();
        System.out.println("\nПолученный файл: ");
        formatter.finalListOutput();
    }
}
