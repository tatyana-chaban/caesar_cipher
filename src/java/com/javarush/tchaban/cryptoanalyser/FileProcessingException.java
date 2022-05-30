package com.javarush.tchaban.cryptoanalyser;

public class FileProcessingException extends RuntimeException {

    String message;

    public FileProcessingException() {
    }

    public FileProcessingException(String message) {
        super(message);
        this.message = message;
    }

    public FileProcessingException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getMessage(){
        return message;
    }
}
