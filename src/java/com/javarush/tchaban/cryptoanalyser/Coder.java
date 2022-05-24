package com.javarush.tchaban.cryptoanalyser;

import java.io.*;


import static com.javarush.tchaban.cryptoanalyser.Alphabet.ALPHABET;

public class Coder {
    private final String filePathToEncrypt;
    private final String filePathToDecrypt;
    private final int key;

    public Coder(String filePathToEncrypt, int key, String filePathToDecrypt) {
        this.filePathToEncrypt = filePathToEncrypt;
        this.key = key;
        this.filePathToDecrypt = filePathToDecrypt;
    }

    public void encoding() throws IOException {
        try (BufferedReader bufferCharFromFile = new BufferedReader(new FileReader(filePathToEncrypt));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePathToDecrypt))) {
            while (bufferCharFromFile.ready()) {
                char oneChar = (char) bufferCharFromFile.read();
                if (ALPHABET.contains(oneChar)) {
                    int position = ALPHABET.indexOf(oneChar);
                    int positionAfterCrypt = position + key;
                    if (positionAfterCrypt >= ALPHABET.size()) {
                        positionAfterCrypt = positionAfterCrypt % ALPHABET.size();
                    }
                    bufferedWriter.write(ALPHABET.get(positionAfterCrypt));
                } else {
                    bufferedWriter.write(oneChar);
                }


            }
        }

    }




    }



