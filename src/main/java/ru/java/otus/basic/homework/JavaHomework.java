package ru.java.otus.basic.homework;


import java.io.*;
import java.util.Scanner;

public class JavaHomework {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название файла: ");
        String name = scanner.nextLine();
        File file = new File(name);
        System.out.print("Введите последовательность: ");
        String str = scanner.nextLine();
        try {
            int result = repeat(file, str);
            System.out.println("Повторений последовательности:  " + result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int repeat(File file, String str) throws FileNotFoundException {
        int numberRepeat = 0;
        StringBuilder currentLine = new StringBuilder();
        int letterPosition = 0;
        String str2;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            for (int i = 0; i < file.length(); i++) {
                char currentLetter = (char) reader.read();
                if (currentLetter == str.charAt(letterPosition)) {
                    currentLine.append(currentLetter);
                    letterPosition++;
                } else {
                    letterPosition = 0;
                    currentLine = new StringBuilder();
                }
                if (letterPosition > str.length() - 1) {
                    letterPosition = 0;
                }
                str2 = currentLine.toString();
                if (str.equals(str2)) {
                    numberRepeat++;
                    letterPosition = 0;
                    currentLine = new StringBuilder();
                }
            }
            return numberRepeat;
        } catch (IOException e) {
            throw new FileNotFoundException("Файл не найден");
        }
    }
}