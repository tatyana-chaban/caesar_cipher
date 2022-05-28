package com.javarush.tchaban.cryptoanalyser;

public class FileProcessingException extends RuntimeException{
    String massage;

    public FileProcessingException(String massage){
        this.massage = massage;

    }

    public String getMassage(){
        return massage;
    }
}
