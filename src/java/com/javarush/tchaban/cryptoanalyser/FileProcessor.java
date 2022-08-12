package com.javarush.tchaban.cryptoanalyser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileProcessor {

    public List<String> readFile(String filename) {
        List<String> listAfterReading;
        try {
            Path path = Validator.returnValidPath(filename);
            listAfterReading = Files.readAllLines(path);
        } catch (IOException ex) {
            throw new FileProcessingException("Error reading file " + filename, ex);
        }
        return listAfterReading;
}

    public void writeToFile(List<String> text, String file) {
            try {
                Path path = Validator.returnValidPath(file);
                Files.write(path, text);
            } catch (IOException ex) {
                throw new FileProcessingException("Error writing file " + file, ex);
            }
    }
}
