package ru.java.otus.basic.homework;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
            System.out.println("Повторений послндовательности:  " + result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int repeat(File file, String str) throws FileNotFoundException {
        int a = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int letter = 0;
        String str2;
        try (FileReader reader = new FileReader(file)) {
            for (int i = 0; i < file.length(); i++) {
                char c = (char) reader.read();
                // System.out.println(c);
                if (c == str.charAt(letter)) {
                    stringBuilder.append(c);
                    letter++;
                } else {
                    letter = 0;
                    stringBuilder = new StringBuilder();
                }
                if (letter > str.length() - 1) {
                    letter = 0;
                }
                str2 = stringBuilder.toString();
                if (str.equals(str2)) {
                    a++;
                    letter = 0;
                    stringBuilder = new StringBuilder();
                }
            }
            return a;
        } catch (IOException e) {
            throw new FileNotFoundException("file not found");
        }
    }
}