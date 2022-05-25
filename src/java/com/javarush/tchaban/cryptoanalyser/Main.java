package com.javarush.tchaban.cryptoanalyser;

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {

        String pathToFileForCrypt = "C:\\Users\\Nimfadora\\IdeaProjects\\caesar_cipher\\src\\forCrypt.txt";
        String pathToDecryptFile = "C:\\Users\\Nimfadora\\IdeaProjects\\caesar_cipher\\Crypt.txt";
        String pathAfterDecrypt = "C:\\Users\\Nimfadora\\IdeaProjects\\caesar_cipher\\DeCrypt.txt";
        int key = 4;

        Coder coder = new Coder(pathToFileForCrypt, key, pathToDecryptFile);
        coder.encoding();

        Decoder decoder = new Decoder(pathToDecryptFile, key, pathAfterDecrypt);
        decoder.decodingWithKey();
        decoder.brutForceDecoding();

    }


}
