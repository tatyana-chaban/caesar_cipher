package com.javarush.tchaban.cryptoanalyser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class FileProcessor {

    //поля и проверка валидности
    public List<String> readFile(String fileForReading) {
        // static methods of Validator
        List<String> stringList;
            try {
                stringList = Files.readAllLines(Path.of(fileForReading));
            } catch (IOException ex){
                throw new FileProcessingException("Problem with file reading ", ex);
            }
        return stringList;
    }

    public void writeToFile(List<String> stringList, String fileForWriting) {
        try {
            Files.write(Path.of(fileForWriting), stringList);
        } catch (IOException ex){
            throw new FileProcessingException("Problem with file writing ", ex);
        }


    }

}
