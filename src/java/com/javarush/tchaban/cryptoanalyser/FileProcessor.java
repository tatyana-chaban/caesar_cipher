package com.javarush.tchaban.cryptoanalyser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class FileProcessor {
    private final String fileForReading;
    private final String fileForWriting;

    public FileProcessor(String fileForReading, String fileForWriting){
        this.fileForReading = fileForReading;
        this.fileForWriting = fileForWriting;
    }

    //поля и проверка валидности
    public List<String> readFile() {
        List<String> stringList = new ArrayList<>();
            try {
                stringList = Files.readAllLines(Path.of(fileForReading));
            } catch (IOException ex){
                throw new FileProcessingException("Problem with file reading ");
            }
            // добавить обработку ио
        return stringList;
    }

    public void writeToFile(List<String> stringList) {
        try {
            Files.write(Path.of(fileForWriting), stringList);
        } catch (IOException ex){
            throw new FileProcessingException("Problem with file writing ");
        }
        // добавить обработку ио

    }

}
