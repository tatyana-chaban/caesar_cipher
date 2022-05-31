package com.javarush.tchaban.cryptoanalyser;

import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {

    public static Path returnValidPath(String filePath) {
        if (filePath == null){
            throw new IllegalArgumentException("Path can't be empty!");
        }
        Path path = Path.of(filePath);
        if (!Files.exists(path)
                || Files.isDirectory(path)
                || filePath.contains("/system32")
                || filePath.contains("/sysWOW64")) {
            throw new IllegalArgumentException("Invalid file path " + filePath);
        } else {
            return path;
        }
    }

    public static int returnValidKey(String keyString) {
        try {
            int key = Integer.parseInt(keyString);
            if (key >= 0 && key < Alphabet.ALPHABET.size()) {
                return key;
            } else if (key < 0) {
                throw new IllegalArgumentException("Key can't be a negative number " + key);
            } else {
                return key % Alphabet.ALPHABET.size();
            }
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("Invalid key " + keyString);
        }
    }
}
