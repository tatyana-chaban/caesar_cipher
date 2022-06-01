package com.javarush.tchaban.cryptoanalyser;

import java.util.List;
import java.util.Scanner;

public class Dialog {
    private static final String ENTER_FILE_FOR_ENCRYPT = "Enter the path to the file to encrypt: ";
    private static final String ENTER_FILE_FOR_DECRYPT = "Enter the path to the file to decrypt: ";
    private static final String ENTER_FILE_FOR_SAVING = "Enter the path to the file to save the result: ";
    private static final String ENTER_KEY = "Enter key: ";
    private static final String SUCCESS = "The operation was successful!";

    public void start() {
        Scanner scanner = new Scanner(System.in);
        FileProcessor fileProcessor = new FileProcessor();
        CaesarCipher caesarCipher = new CaesarCipher();
        while (true) {
            printStartInfo();
            String choice = scanner.nextLine();
            if ("1".equals(choice)) {
                try {
                    System.out.println(ENTER_FILE_FOR_ENCRYPT);
                    String fileForEncrypt = scanner.nextLine();

                    System.out.println(ENTER_FILE_FOR_SAVING);
                    String fileForSaving = scanner.nextLine();

                    System.out.println(ENTER_KEY);
                    int key = Validator.returnValidKey(scanner.nextLine());

                    List<String> textForCrypt = fileProcessor.readFile(fileForEncrypt);
                    List<String> textAfterCrypt = caesarCipher.encoding(textForCrypt, key);
                    fileProcessor.writeToFile(textAfterCrypt, fileForSaving);
                    System.out.println(SUCCESS);

                } catch (IllegalArgumentException | FileProcessingException ex) {
                    System.out.println(ex.getMessage());
                }
                break;

            } else if ("2".equals(choice)) {
                try {
                    System.out.println(ENTER_FILE_FOR_DECRYPT);
                    String fileForDecrypt = scanner.nextLine();

                    System.out.println(ENTER_FILE_FOR_SAVING);
                    String fileForSaving = scanner.nextLine();

                    System.out.println(ENTER_KEY);
                    int key = Validator.returnValidKey(scanner.nextLine());

                    List<String> textForDecrypt = fileProcessor.readFile(fileForDecrypt);
                    List<String> textAfterDecrypt = caesarCipher.decodingWithKey(textForDecrypt, key);
                    fileProcessor.writeToFile(textAfterDecrypt, fileForSaving);
                    System.out.println(SUCCESS);

                } catch (IllegalArgumentException | FileProcessingException ex) {
                    System.out.println(ex.getMessage());
                }
                break;

            } else if ("3".equals(choice)) {
                try {
                    System.out.println(ENTER_FILE_FOR_DECRYPT);
                    String fileForDecrypt = scanner.nextLine();

                    System.out.println(ENTER_FILE_FOR_SAVING);
                    String fileForSaving = scanner.nextLine();

                    List<String> textForDecrypt = fileProcessor.readFile(fileForDecrypt);
                    List<String> textAfterDecrypt = caesarCipher.bruteForceDecoding(textForDecrypt);
                    fileProcessor.writeToFile(textAfterDecrypt, fileForSaving);
                    System.out.println(SUCCESS);

                } catch (IllegalArgumentException | FileProcessingException ex) {
                    System.out.println(ex.getMessage());
                }
                break;

            } else if ("exit".equalsIgnoreCase(choice)) {
                break;

            } else {
                System.out.println("Invalid data. Try again");
            }
        }
    }

    private void printStartInfo() {
        System.out.println("""
                Selecting the operating mode. Enter:
                 1 - for text encryption;
                 2 - to decrypt the text using a known key;
                 3 - for decryption using the BruteForce method;
                 exit - to exit the program.
                """);
    }
}

