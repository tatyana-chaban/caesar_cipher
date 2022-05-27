package com.javarush.tchaban.cryptoanalyser;

import java.io.*;
import static com.javarush.tchaban.cryptoanalyser.Alphabet.ALPHABET;

public class Coder {
    private final String filePathToEncrypt;
    private final String filePathToDecrypt;
    private final FileProcessor fileProcessor = new FileProcessor();

    public Coder(String filePathToEncrypt, int key, String filePathToDecrypt) {
        this.filePathToEncrypt = filePathToEncrypt;
        this.filePathToDecrypt = filePathToDecrypt;
    }

    public void encoding(int key) throws IOException {
        char[] text = fileProcessor.readFile(filePathToEncrypt);
        StringBuilder stringBuilder = new StringBuilder();
        for (char symbol : text) {
            if (ALPHABET.contains(symbol)) {
                int position = ALPHABET.indexOf(symbol);
                int positionAfterCrypt = position + key;
                if (positionAfterCrypt >= ALPHABET.size()) {
                    positionAfterCrypt = positionAfterCrypt % ALPHABET.size();
                }
                stringBuilder.append(ALPHABET.get(positionAfterCrypt));
            } else {
                stringBuilder.append(symbol);
            }
        }
        fileProcessor.writeToFile(stringBuilder.toString().toCharArray(), filePathToDecrypt);


    }
}





