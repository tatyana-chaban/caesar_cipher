package com.javarush.tchaban.cryptoanalyser;

import java.util.ArrayList;
import java.util.List;

import static com.javarush.tchaban.cryptoanalyser.Alphabet.ALPHABET;

public class Coder {
    public static List<String> encoding(List<String> listForCrypt, int key) {
        List<String> encryptList = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        for (String line : listForCrypt) {
            for (char symbol : line.toCharArray()) {
                if (ALPHABET.contains(symbol)) {
                    int position = ALPHABET.indexOf(symbol);
                    int positionAfterCrypt = position + key;
                    if (positionAfterCrypt >= ALPHABET.size()) {
                        positionAfterCrypt = positionAfterCrypt % ALPHABET.size();
                    }
                    buffer.append(ALPHABET.get(positionAfterCrypt));
                }
            }
            encryptList.add(buffer.toString());
        }
        return encryptList;
    }
}





