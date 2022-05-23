package com.javarush.tchaban.cryptoanalyser;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        final List<Character> ALPHABET = Arrays.asList('а', 'б', 'в',
                'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
                'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»',
                ':', '!', '?', ' ');
        String pathToFileForCrypt = "C:\\Users\\Nimfadora\\IdeaProjects\\caesar_cipher\\src\\forCrypt.txt";
        int key = 3;

        // Scanner scanner = new Scanner(System.in);
        // pathToFileForCrypt = scanner.nextLine();
        // key = scanner.nextInt();


        BufferedReader bufferCharFromFile = new BufferedReader(new FileReader(pathToFileForCrypt));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\Nimfadora\\IdeaProjects\\caesar_cipher\\Crypt.txt"));
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
        bufferedWriter.close();
        bufferCharFromFile.close();

/////////////////////////

        BufferedReader bufferCrypt = new BufferedReader(new FileReader("C:\\Users\\Nimfadora\\IdeaProjects\\caesar_cipher\\Crypt.txt"));
        BufferedWriter bufferDecrypt = new BufferedWriter(new FileWriter("C:\\Users\\Nimfadora\\IdeaProjects\\caesar_cipher\\DeCrypt.txt"));
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
        bufferDecrypt.close();
        bufferCrypt.close();

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
