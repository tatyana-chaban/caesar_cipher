package com.javarush.tchaban.cryptoanalyser;


import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printStartInfo();
            String choice = scanner.nextLine();

            if ("1".equals(choice)) {
                try {
                    System.out.println("Введите путь к файлу для шифрования: ");
                    String fileForCrypt = scanner.nextLine();

                    System.out.println("Введите путь к файлу для сохранения зашифрованного текста: ");
                    String fileForSaving = scanner.nextLine();

                    System.out.println("Введите ключ для шифрования: ");
                    int key = Validator.returnValidKey(scanner.nextLine());

                    FileProcessor fileProcessor = new FileProcessor();
                    List<String> textForCrypt = fileProcessor.readFile(fileForCrypt);
                    List<String> textAfterCrypt = Coder.encoding(textForCrypt, key);
                    fileProcessor.writeToFile(textAfterCrypt, fileForSaving);

                } catch (IllegalArgumentException | FileProcessingException ex) {
                    System.out.println(ex.getMessage());
                }


                break;

            } else if ("2".equals(choice)) {
                try {
                    System.out.println("Введите путь к файлу для расшифровки: ");
                    String fileForDecrypt = scanner.nextLine();

                    System.out.println("Введите путь к файлу для сохранения расшифрованного текста: ");
                    String fileForSaving = scanner.nextLine();

                    System.out.println("Введите ключ для расшифровки: ");
                    int key = Validator.returnValidKey(scanner.nextLine());

                    FileProcessor fileProcessor = new FileProcessor();
                    List<String> textForDecrypt = fileProcessor.readFile(fileForDecrypt);
                    List<String> textAfterDecrypt = Decoder.decodingWithKey(textForDecrypt, key);
                    fileProcessor.writeToFile(textAfterDecrypt, fileForSaving);

                } catch (IllegalArgumentException | FileProcessingException ex) {
                    System.out.println(ex.getMessage());
                }
                break;

            } else if ("3".equals(choice)) {
                try {
                    System.out.println("Введите путь к файлу для расшифровки: ");
                    String fileForDecrypt = scanner.nextLine();

                    System.out.println("Введите путь к файлу для сохранения расшифрованного текста: ");
                    String fileForSaving = scanner.nextLine();

                    FileProcessor fileProcessor = new FileProcessor();
                    List<String> textForDecrypt = fileProcessor.readFile(fileForDecrypt);
                    List<String> textAfterDecrypt = Decoder.brutForceDecoding(textForDecrypt);
                    fileProcessor.writeToFile(textAfterDecrypt, fileForSaving);

                } catch (IllegalArgumentException | FileProcessingException ex) {
                    System.out.println(ex.getMessage());
                }
                break;

            } else if ("4".equals(choice)) {
                System.out.println("Введите путь к файлу с репрезентативным текстом: ");
                String representFile = scanner.nextLine();
                System.out.println("Введите путь к файлу для расшифровки: ");
                String fileForDecrypt = scanner.nextLine();
                System.out.println("Введите путь к файлу для сохранения расшифрованного текста: ");
                String fileForSaving = scanner.nextLine();
                break;

            } else if ("exit".equals(choice)) {
                break;

            } else {
                System.out.println("Некорректные данные. Повторите попытку.");
            }


        }


    }

    public static void printStartInfo() {
        System.out.println("""
                Выбор режима работы. Введите:\s
                1 - для шифрования текста;
                2 - для расшифровки текса по известному ключу;
                3 - для расшифровки методом BrutForce;
                4 - для расшифровки методом статистического анализа;
                exit - для выхода из программы.
                """);
    }


}
