package com.javarush.tchaban.cryptoanalyser;

import java.io.*;

import static com.javarush.tchaban.cryptoanalyser.Alphabet.ALPHABET;

public class Decoder {
    private final String filePathToEncrypt;
    private final String filePathToDecrypt;
    private final int key;

    public Decoder(String filePathToEncrypt, int key, String filePathToDecrypt) {
        this.filePathToEncrypt = filePathToEncrypt;
        this.key = key;
        this.filePathToDecrypt = filePathToDecrypt;
    }

    public void decoding() throws IOException {
        try (BufferedReader bufferCrypt = new BufferedReader(new FileReader(filePathToEncrypt));
             BufferedWriter bufferDecrypt = new BufferedWriter(new FileWriter(filePathToDecrypt))) {
            while (bufferCrypt.ready()) {
            char oneChar = (char) bufferCrypt.read();
            if (ALPHABET.contains(oneChar)) {
                int position = ALPHABET.indexOf(oneChar);
                int positionAfterDeCrypt = position - key;
                if (positionAfterDeCrypt < 0) {
                    positionAfterDeCrypt = ALPHABET.size() + positionAfterDeCrypt;
                }
                bufferDecrypt.write(ALPHABET.get(positionAfterDeCrypt));
            } else {
                bufferDecrypt.write(oneChar);
            }
            }
        }
    }
}


