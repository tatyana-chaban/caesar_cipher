package com.javarush.tchaban.cryptoanalyser;

import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("""
                Выбор режима работы. Введите:\s
                1 - для шифрования текста;
                2 - для расшифровки текса по известному ключу;
                3 - для расшифровки методом BrutForce;
                4 - для расшифровки методом статистического анализа;
                exit - для выхода из программы.
                """);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String choice = scanner.nextLine();

            if ("1".equals(choice)) {
                System.out.println("Введите путь к файлу для шифрования: ");
                String fileForCrypt = scanner.nextLine();
                System.out.println("Введите путь к файлу для сохранения зашифрованного текста: ");
                String fileForSaving = scanner.nextLine();
                System.out.println("Введите ключ для шифрования: ");
                int key = scanner.nextInt();

                try {
                    // проверка на валидность
                    Coder coder = new Coder(fileForCrypt, key, fileForSaving);
                    coder.encoding(key);
                } catch (Exception ex){

                }
                    //отлавливание ошибок валидации и файлпроцессор


                break;

            } else if ("2".equals(choice)) {
                System.out.println("Введите путь к файлу для расшифровки: ");
                String fileForDecrypt = scanner.nextLine();
                System.out.println("Введите путь к файлу для сохранения расшифрованного текста: ");
                String fileForSaving = scanner.nextLine();
                System.out.println("Введите ключ для расшифровки: ");
                int key = scanner.nextInt();

                try {
                    // проверка на валидность
                    Decoder decoder = new Decoder(fileForDecrypt, fileForSaving);
                    decoder.decodingWithKey(key);
                } catch (Exception ex){

                }
                //отлавливание ошибок валидации и файлпроцессор
                break;

            } else if ("3".equals(choice)) {
                System.out.println("Введите путь к файлу для расшифровки: ");
                String fileForDecrypt = scanner.nextLine();
                System.out.println("Введите путь к файлу для сохранения расшифрованного текста: ");
                String fileForSaving = scanner.nextLine();

                try {
                    // проверка на валидность
                    Decoder decoder = new Decoder(fileForDecrypt, fileForSaving);
                    decoder.brutForceDecoding();
                } catch (Exception ex){

                }
                //отлавливание ошибок валидации и файлпроцессор
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


        String pathToFileForCrypt = "C:\\Users\\Nimfadora\\IdeaProjects\\caesar_cipher\\src\\forCrypt.txt";
        String pathToDecryptFile = "C:\\Users\\Nimfadora\\IdeaProjects\\caesar_cipher\\Crypt.txt";
        String pathAfterDecrypt = "C:\\Users\\Nimfadora\\IdeaProjects\\caesar_cipher\\DeCrypt.txt";
        int key = 4;


    }


}
