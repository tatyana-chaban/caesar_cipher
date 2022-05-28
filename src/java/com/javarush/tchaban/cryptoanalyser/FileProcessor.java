package com.javarush.tchaban.cryptoanalyser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class FileProcessor {

    public List<String> readFile(String fileForReading) {
        if (Validator.isValidPath(fileForReading)) {
            List<String> stringList;
            try {
                stringList = Files.readAllLines(Path.of(fileForReading));
            } catch (IOException ex) {
                throw new FileProcessingException("Problem with file reading ", ex);
            }
            return stringList;
        } else {
            throw new IllegalArgumentException("Incorrect path to file " + fileForReading);
        }
    }

    public void writeToFile(List<String> stringList, String fileForWriting) {
        if(Validator.isValidPath(fileForWriting)) {
            try {
                Files.write(Path.of(fileForWriting), stringList);
            } catch (IOException ex) {
                throw new FileProcessingException("Problem with file writing ", ex);
            }
        } else {
            throw new IllegalArgumentException("Incorrect path to file " + fileForWriting);
        }


    }

}
