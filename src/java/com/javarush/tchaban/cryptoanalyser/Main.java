package com.javarush.tchaban.cryptoanalyser;

import java.io.*;


import static com.javarush.tchaban.cryptoanalyser.Alphabet.ALPHABET;

public class Main {
    public static void main(String[] args) throws IOException {

        String pathToFileForCrypt = "C:\\Users\\Nimfadora\\IdeaProjects\\caesar_cipher\\src\\forCrypt.txt";
        String pathToDecryptFile = "C:\\Users\\Nimfadora\\IdeaProjects\\caesar_cipher\\Crypt.txt";
        String pathAfterDecrypt = "C:\\Users\\Nimfadora\\IdeaProjects\\caesar_cipher\\DeCrypt.txt";
        int key = 4;

        Coder coder = new Coder(pathToFileForCrypt, key, pathToDecryptFile);
        coder.encoding();


/////////////////////////
        Decoder decoder = new Decoder(pathToDecryptFile, key, pathAfterDecrypt);
        decoder.decoding();

//        BufferedReader bufferCrypt = new BufferedReader(new FileReader("C:\\Users\\Nimfadora\\IdeaProjects\\caesar_cipher\\Crypt.txt"));
//        BufferedWriter bufferDecrypt = new BufferedWriter(new FileWriter("C:\\Users\\Nimfadora\\IdeaProjects\\caesar_cipher\\DeCrypt.txt"));
//        while (bufferCrypt.ready()) {
//            char oneChar = (char) bufferCrypt.read();
//            if (ALPHABET.contains(oneChar)) {
//                int position = ALPHABET.indexOf(oneChar);
//                int positionAfterDeCrypt = position - key;
//                if (positionAfterDeCrypt < 0) {
//                    positionAfterDeCrypt = ALPHABET.size() + positionAfterDeCrypt;
//                }
//                bufferDecrypt.write(ALPHABET.get(positionAfterDeCrypt));
//            } else {
//                bufferDecrypt.write(oneChar);
//            }
//
//        }
//        bufferDecrypt.close();
//        bufferCrypt.close();

//////////////////////////////
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Nimfadora\\IdeaProjects\\caesar_cipher\\Crypt.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Nimfadora\\IdeaProjects\\caesar_cipher\\DeCryptBrut.txt"));

        StringBuilder stringBuilder = new StringBuilder();
        while (reader.ready()) {
            stringBuilder.append((char) reader.read());
        }
        for (int ourKey = 0; ourKey < ALPHABET.size(); ourKey++) {
            StringBuilder stringBuilder2 = new StringBuilder();
            for (int i = 0; i < stringBuilder.length(); i++) {
                char oneChar = stringBuilder.charAt(i);
                if (ALPHABET.contains(oneChar)) {
                    int position = ALPHABET.indexOf(oneChar);
                    int positionAfterDeCrypt = position - ourKey;
                    if (positionAfterDeCrypt < 0) {
                        positionAfterDeCrypt = ALPHABET.size() + positionAfterDeCrypt;
                    }
                    stringBuilder2.append(ALPHABET.get(positionAfterDeCrypt));
                } else {
                    stringBuilder2.append(oneChar);
                }
            }
            String text = stringBuilder2.toString();
            if (text.contains(". ") && text.contains(", ")) {
                writer.write(text);
                break;
            }
        }

        reader.close();
        writer.close();
    }


}
