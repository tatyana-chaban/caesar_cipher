package com.javarush.tchaban.cryptoanalyser;

import java.util.ArrayList;
import java.util.List;

import static com.javarush.tchaban.cryptoanalyser.Alphabet.ALPHABET;

public class CaesarCipher {
    private static final String FIRST_MARKER_OF_SUCCESS = ". ";
    private static final String SECOND_MARKER_OF_SUCCESS = ", ";

    public List<String> encoding(List<String> listForCrypt, int key) {
        return caesarCipherProcessing(listForCrypt, key);
    }

    public List<String> decodingWithKey(List<String> listForDecrypt, int key) {
        return caesarCipherProcessing(listForDecrypt, -key);
    }

    public List<String> bruteForceDecoding(List<String> listForDecrypt) {
        List<String> decryptList = new ArrayList<>();
        for (int key = 0; key < ALPHABET.size(); key++) {
            decryptList = decodingWithKey(listForDecrypt, key);
            String textAfterDecrypt = decryptList.toString();

            if (textAfterDecrypt.contains(FIRST_MARKER_OF_SUCCESS)
                    && textAfterDecrypt.contains(SECOND_MARKER_OF_SUCCESS)) {
                return decryptList;
            }
        }
        return decryptList;
    }

    private List<String> caesarCipherProcessing(List<String> listForCrypt, int key) {
        List<String> processingList = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        for (String line : listForCrypt) {
            for (char symbol : line.toCharArray()) {
                if (ALPHABET.contains(symbol)) {
                    int position = ALPHABET.indexOf(symbol);
                    int positionAfterProcessing = position + key;
                    if (positionAfterProcessing >= ALPHABET.size()) {
                        positionAfterProcessing %= ALPHABET.size();
                    }
                    if (positionAfterProcessing < 0) {
                        positionAfterProcessing += ALPHABET.size();
                    }
                    buffer.append(ALPHABET.get(positionAfterProcessing));
                }
            }
            processingList.add(buffer.toString());
            buffer = new StringBuilder();
        }
        return processingList;
    }
}

