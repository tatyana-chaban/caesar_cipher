package com.javarush.tchaban.cryptoanalyser;

import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {
    public static boolean isValidPath(String filePath) {
        Path path = Path.of(filePath);
        return !Files.isDirectory(path)
                && !filePath.contains("/system32")
                && !filePath.contains("/sysWOW64");
    }

    public static int returnValidKey(String keyString) {
        try {
            int key = Integer.parseInt(keyString);
            if (key >= 0 && key < Alphabet.ALPHABET.size()) {
                return key;
            } else if (key < 0){
               throw new IllegalArgumentException("Ключ не может быть отрицательным числом " + key);
            } else {
                return key % Alphabet.ALPHABET.size();
            }
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Некорректный ключ " + keyString);
        }

    }

}




