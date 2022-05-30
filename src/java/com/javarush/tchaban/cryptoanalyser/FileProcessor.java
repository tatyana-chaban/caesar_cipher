package com.javarush.tchaban.cryptoanalyser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class FileProcessor {

    public List<String> readFile(String fileForReading) {
        List<String> listAfterReading;
        try {
            Path path = Validator.returnValidPath(fileForReading);
            listAfterReading = Files.readAllLines(path);
        } catch (IOException ex) {
            throw new FileProcessingException("Ошибка чтения файла " + fileForReading, ex);
        }
        return listAfterReading;
}


    public void writeToFile(List<String> stringList, String fileForWriting) {
            try {
                Path path = Validator.returnValidPath(fileForWriting);
                Files.write(path, stringList);
            } catch (IOException ex) {
                throw new FileProcessingException("Ошибка записи файла " + fileForWriting, ex);
            }

    }

}
