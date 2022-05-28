package com.javarush.tchaban.cryptoanalyser;


import java.util.ArrayList;
import java.util.List;

import static com.javarush.tchaban.cryptoanalyser.Alphabet.ALPHABET;

public class Decoder {

    public static List<String> decodingWithKey(List<String> text, int key) {
        List<String> decryptList = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        for (String line : text) {
            for (char symbol : line.toCharArray()) {
                int position = ALPHABET.indexOf(symbol);
                int positionAfterDecrypt = position - key;
                if (positionAfterDecrypt < 0) {
                    positionAfterDecrypt = ALPHABET.size() + positionAfterDecrypt;
                }
                buffer.append(ALPHABET.get(positionAfterDecrypt));
            }
            decryptList.add(buffer.toString());
        }
        return decryptList;

    }


    public static List<String> brutForceDecoding(List<String> text) {
        List<String> decryptList = new ArrayList<>();
        for (int ourKey = 0; ourKey < ALPHABET.size(); ourKey++) {
            decryptList = decodingWithKey(text, ourKey);
            String textAfterDecrypt = decryptList.toString();

            if (textAfterDecrypt.contains(". ") && textAfterDecrypt.contains(", ")) {
                return decryptList;
            }
        }
        return decryptList;
    }
}


