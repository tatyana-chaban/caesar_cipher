package com.javarush.tchaban.cryptoanalyser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class FileProcessor {
    public char[] readFile(String fileName) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        if (Validator.isValidPath(fileName)) {
            try (BufferedReader reader = Files.newBufferedReader(Path.of(fileName))) {
                while (reader.ready()){
                    stringBuilder.append(reader.readLine());
                    stringBuilder.append('\n');
                }
            }
        } else {
            throw new FileProcessorException();
        }
        return stringBuilder.toString().toCharArray();
    }

    public void writeToFile(char[] textArray, String fileName) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(fileName))) {
            writer.write(textArray);
        }

    }

}
