package com.javarush.tchaban.cryptoanalyser;

import java.io.*;

import static com.javarush.tchaban.cryptoanalyser.Alphabet.ALPHABET;

public class Decoder {
    private final String filePathToEncrypt;
    private final String filePathToDecrypt;
    private final int key;
    private final FileProcessor fileProcessor = new FileProcessor();

    public Decoder(String filePathToEncrypt, int key, String filePathToDecrypt) {
        this.filePathToEncrypt = filePathToEncrypt;
        this.key = key;
        this.filePathToDecrypt = filePathToDecrypt;
    }

    public void decodingWithKey() throws IOException {
        char[] text = fileProcessor.readFile(filePathToEncrypt);
        StringBuilder stringBuilder = new StringBuilder();
        for (char symbol : text) {
            if (ALPHABET.contains(symbol)) {
                int position = ALPHABET.indexOf(symbol);
                int positionAfterDeCrypt = position - key;
                if (positionAfterDeCrypt < 0) {
                    positionAfterDeCrypt = ALPHABET.size() + positionAfterDeCrypt;
                }
                stringBuilder.append(ALPHABET.get(positionAfterDeCrypt));
            } else {
                stringBuilder.append(symbol);
            }
        }
        fileProcessor.writeToFile(stringBuilder.toString().toCharArray(), filePathToDecrypt);
    }


    public void brutForceDecoding() throws IOException {
        char[] text = fileProcessor.readFile(filePathToEncrypt);

        for (int ourKey = 0; ourKey < ALPHABET.size(); ourKey++) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (char symbol : text) {
                if (ALPHABET.contains(symbol)) {
                    int position = ALPHABET.indexOf(symbol);
                    int positionAfterDeCrypt = position - ourKey;
                    if (positionAfterDeCrypt < 0) {
                        positionAfterDeCrypt = ALPHABET.size() + positionAfterDeCrypt;
                    }
                    stringBuilder2.append(ALPHABET.get(positionAfterDeCrypt));
                } else {
                    stringBuilder2.append(symbol);
                }
            }
            String textAfterDecrypt = stringBuilder2.toString();
            if (textAfterDecrypt.contains(". ") && textAfterDecrypt.contains(", ")) {
                fileProcessor.writeToFile(textAfterDecrypt.toCharArray(), filePathToDecrypt);
                break;
            }

        }
    }
}


