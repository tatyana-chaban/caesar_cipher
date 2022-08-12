package com.javarush.tchaban.cryptoanalyser;

import java.util.ArrayList;
import java.util.List;
import static com.javarush.tchaban.cryptoanalyser.Alphabet.ALPHABET;

public class CaesarCipher {
    private static final String MARKER_OF_SUCCESS = ". ";

    public List<String> encoding(List<String> text, int key) {
        return process(text, key);
    }

    public List<String> decodingWithKey(List<String> text, int key) {
        return process(text, -key);
    }

    public List<String> bruteForceDecoding(List<String> text) {
        List<String> decryptList = new ArrayList<>();
        for (int key = 0; key < ALPHABET.size(); key++) {
            decryptList = decodingWithKey(text, key);
            String decryptedText = decryptList.toString();

            if (decryptedText.contains(MARKER_OF_SUCCESS)) {
                return decryptList;
            }
        }
        return decryptList;
    }

    private List<String> process(List<String> text, int key) {
        List<String> processingList = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        for (String line : text) {
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

